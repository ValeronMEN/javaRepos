package com.example.egorhelminth_surfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleManager {
    private ArrayList<Obstacle> obstacles;
    private int obstacleGap;
    private int obstacleSize;

    private long startTime;
    private long initTime;

    private int score = 0;

    private Helminth player;

    private Rect [] backgroundRectangles;
    private Bitmap backgroundBitmap;

    private Gosha goshaObj;
    private Diablo diablo;

    private MediaPlayer mp;

    private BonusTimer bonusTimerShuba;
    private BonusTimer bonusTimerShoe;

    public ObstacleManager(int obstacleGap, int obstacleSize, Helminth player){
        this.obstacleGap = obstacleGap;
        this.obstacleSize = obstacleSize;
        this.player = player;
        this.mp = MediaPlayer.create(Constants.CURRENT_CONTEXT, R.raw.bm_helminth);

        startTime = initTime = System.currentTimeMillis();
        obstacles = new ArrayList<Obstacle>();

        populateObstacles();

        BitmapFactory bf = new BitmapFactory();
        this.backgroundBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.background_simple);

        Rect backgroundRect1 = new Rect(0, 0, Constants.SCREEN_WIDTH, 2*Constants.SCREEN_HEIGHT);
        Rect backgroundRect2 = new Rect(0, -2*Constants.SCREEN_HEIGHT, Constants.SCREEN_WIDTH, 0);
        this.backgroundRectangles = new Rect[]{backgroundRect1, backgroundRect2};

        bonusTimerShuba = new BonusTimer(Constants.SCREEN_WIDTH/3, (int)(Constants.SCREEN_HEIGHT/15.0),
                Color.MAGENTA, player, "shuba", 412000);
        bonusTimerShoe = new BonusTimer(2*Constants.SCREEN_WIDTH/3, (int)(Constants.SCREEN_HEIGHT/15.0),
                Color.BLUE, player, "shoe", 30000);

        diablo = new Diablo();
        goshaObj = new Gosha();
    }

    public boolean playerCollide(Helminth player){
        for(Obstacle ob : obstacles){
            int collision = ob.playerCollide(player);
            if(collision == 0){
                continue;
            }else if(collision == -1){
                if(player.getImmortality()){
                    ob.setVisibility(false);
                }else{
                    if(mp.isPlaying())
                        mp.stop();
                    return true;
                }
            }else if(collision == 1){ // meat
                score++;
                ob.setVisibility(false);
            }else if(collision == 2){ // SHOE
                player.setCurrentHelminthState(1);
                ob.setVisibility(false);
                this.diablo.makeActive();
                bonusTimerShoe.start();
            }else if(collision == 3){ // SHUBA
                player.setCurrentHelminthState(2);
                ob.setVisibility(false);
                this.goshaObj.makeActive();
                mp.reset();
                mp.setLooping(false);
                mp.start();
                bonusTimerShuba.start();
            }
        }
        return false;
    }

    private void populateObstacles(){
        int currY = -2*Constants.SCREEN_HEIGHT; //-5*Constants.SCREEN_HEIGHT/4;
        while(currY < 0){
            Obstacle[] sixObstacles = getSixObstacles(currY, obstacleSize, obstacleGap);

            for(int i=0; i<sixObstacles.length; i++){
                if(sixObstacles[i] != null){
                    obstacles.add(sixObstacles[i]);
                }
            }

            currY += ((obstacleSize + obstacleGap) * 2);
        }
    }

    private Obstacle[] getSixObstacles(int obstacleY, int obstacleSize, int obstacleGap){
        Obstacle[] sixObstacles = new Obstacle[6];
        boolean [] tabletteRow = new boolean[3];
        for(boolean tab : tabletteRow)
            tab = false;

        Random rand = new Random();
        int tablettesAmount = 2; // 0, 1 or 2
        int tabletteProbability = rand.nextInt(31);
        if(tabletteProbability < 5){
            tablettesAmount = 0;
        }else if(tabletteProbability < 15){
            tablettesAmount = 1;
        }

        int tablettePos1 = -1;
        int tablettePos2 = -1;

        switch(tablettesAmount){
            case 0:
                break;
            case 1:
                tablettePos1 = rand.nextInt(3);
                break;
            case 2:
                tablettePos1 = rand.nextInt(3);
                tablettePos2 = rand.nextInt(3);
                while(tablettePos1 == tablettePos2){
                    tablettePos2 = rand.nextInt(3);
                }
                break;
        }

        if(tablettePos1 != -1){
            tabletteRow[tablettePos1] = true;
        }
        if(tablettePos2 != -1){
            tabletteRow[tablettePos2] = true;
        }

        sixObstacles[0] = getRandomObstacle(0, obstacleY, obstacleSize, tabletteRow[0]);
        sixObstacles[1] = getRandomObstacle(1, obstacleY, obstacleSize, tabletteRow[1]);
        sixObstacles[2] = getRandomObstacle(2, obstacleY, obstacleSize, tabletteRow[2]);
        sixObstacles[3] = getRandomObstacle(0, obstacleY + obstacleSize + obstacleGap, obstacleSize, false);
        sixObstacles[4] = getRandomObstacle(1, obstacleY + obstacleSize + obstacleGap, obstacleSize, false);
        sixObstacles[5] = getRandomObstacle(2, obstacleY + obstacleSize + obstacleGap, obstacleSize, false);

        return sixObstacles;
    }

    private Obstacle getRandomObstacle(int pathX, int obstacleY, int obstacleSize, boolean isTablette){
        if(isTablette){
            return new Obstacle(pathX, obstacleY, "TABLETTE", obstacleSize);
        }

        Random rand = new Random();

        if(rand.nextInt(100) <= 3 && !player.getImmortality()){
            return new Obstacle(pathX, obstacleY, "SHOE", obstacleSize);
        }
        if(rand.nextInt(100) <= 3 && !player.getInShuba()){
            return new Obstacle(pathX, obstacleY, "SHUBA", obstacleSize);
        }
        if(rand.nextInt(100) <= 50){
            return new Obstacle(pathX, obstacleY, "meat", obstacleSize);
        }
        Obstacle nullObstacle = new Obstacle(pathX, obstacleY, "meat", obstacleSize);
        nullObstacle.setVisibility(false);
        return nullObstacle;
    }

    public void update(){
        if(startTime < Constants.INIT_TIME)
            startTime = Constants.INIT_TIME;
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float) Math.sqrt(1 + (startTime - initTime)/5000)*Constants.SCREEN_HEIGHT/10000.0f;

        for(Obstacle ob : obstacles){
            ob.incrementY(speed * elapsedTime);
        }

        if(obstacles.get(obstacles.size() - 6).getRectangle().top >= Constants.SCREEN_HEIGHT){
            Obstacle[] sixObstacles = getSixObstacles(obstacles.get(0).getRectangle().top - 3*obstacleSize/2 - 2*obstacleGap, obstacleSize, obstacleGap);

            for(int i=sixObstacles.length-1; i>=0; i--){
                if(sixObstacles[i] != null){
                    obstacles.add(0, sixObstacles[i]);
                }
            }

            for(int i=0; i<6;i++){
                obstacles.remove(obstacles.size() - 1);
            }
        }


        // background updating
        for(Rect backgroundRectangle : backgroundRectangles) {
            backgroundRectangle.top += speed * elapsedTime;
            backgroundRectangle.bottom += speed * elapsedTime;
        }
        if(backgroundRectangles[0].top >= Constants.SCREEN_HEIGHT){
            backgroundRectangles[0].top = backgroundRectangles[1].top-2*Constants.SCREEN_HEIGHT;
            backgroundRectangles[0].bottom = backgroundRectangles[1].top;
        }
        if(backgroundRectangles[1].top >= Constants.SCREEN_HEIGHT){
            backgroundRectangles[1].top = backgroundRectangles[0].top-2*Constants.SCREEN_HEIGHT;
            backgroundRectangles[1].bottom = backgroundRectangles[0].top;
        }

        // bonus timers
        bonusTimerShoe.update();
        bonusTimerShuba.update();

        goshaObj.update();
        diablo.update();
    }

    public void draw(Canvas canvas){
        // background drawing
        for(Rect backgroundRectangle : backgroundRectangles){
            canvas.drawBitmap(backgroundBitmap, null, backgroundRectangle, new Paint());
        }

        // obstacles drawing
        for(Obstacle ob : obstacles){
            ob.draw(canvas);
        }
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(100);
        canvas.drawText("" + score, 50, 50 + paint.descent() - paint.ascent(), paint);

        // bonus timers
        bonusTimerShoe.draw(canvas);
        bonusTimerShuba.draw(canvas);

        goshaObj.draw(canvas);
        diablo.draw(canvas);
    }
}
