package com.example.egorhelminth_surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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

    public ObstacleManager(int obstacleGap, int obstacleSize, Helminth player){
        this.obstacleGap = obstacleGap;
        this.obstacleSize = obstacleSize;
        this.player = player;

        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<Obstacle>();

        populateObstacles();
    }

    /*
    public boolean playerCollide(Helminth player){
        for(Obstacle ob : obstacles){
            if(ob.playerCollide(player)){
                return true;
            }
        }
        return false;
    }

     */

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
        int tablettesAmount = rand.nextInt(2); // 0, 1 or 2

        int tablettePos1 = -1;
        int tablettePos2 = -1;

        switch(tablettesAmount){
            case 0:
                break;
            case 1:
                tablettePos1 = rand.nextInt(2);
                break;
            case 2:
                tablettePos1 = rand.nextInt(2);
                tablettePos2 = rand.nextInt(2);
                while(tablettePos1 == tablettePos2){
                    tablettePos2 = rand.nextInt(2);
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
            return new Obstacle(pathX, obstacleY, "tablette", obstacleSize);
        }

        Random rand = new Random();

        if(rand.nextInt(100) <= 3 && player.getCurrentHelminthState() != 1){
            return new Obstacle(pathX, obstacleY, "shoe", obstacleSize);
        }
        if(rand.nextInt(100) <= 3 && player.getCurrentHelminthState() != 2){
            return new Obstacle(pathX, obstacleY, "shuba", obstacleSize);
        }
        if(rand.nextInt(100) <= 50){
            return new Obstacle(pathX, obstacleY, "meat", obstacleSize);
        }
        return null;
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
            Obstacle[] sixObstacles = getSixObstacles(obstacles.get(0).getRectangle().top - obstacleSize/2 - obstacleGap, obstacleSize, obstacleGap);

            for(int i=0; i<sixObstacles.length; i++){
                if(sixObstacles[i] != null){
                    obstacles.add(0, sixObstacles[i]);
                }
            }

            for(int i=0; i<6;i++){
                obstacles.remove(obstacles.size() - 1);
            }
        }
    }

    public void draw(Canvas canvas){
        for(Obstacle ob : obstacles){
            ob.draw(canvas);
        }
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(100);
        canvas.drawText("" + score, 50, 50 + paint.descent() - paint.ascent(), paint);
    }
}
