package com.example.egorhelminth_surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

public class GameplayScene implements Scene {
    private Rect r = new Rect();

    private Helminth player;
    private Point playerPoint;
    private ObstacleManager obstacleManager;

    private boolean gameOver = false;
    private boolean movingPlayer = false;
    private long gameOverTime;

    private float touchStartX;

    public GameplayScene(){
        Constants.PLAYER_Y = (int)(5*Constants.SCREEN_HEIGHT/6);
        Constants.PLAYER_X_0 = Constants.SCREEN_WIDTH/5;
        Constants.PLAYER_X_1 = Constants.SCREEN_WIDTH/2;
        Constants.PLAYER_X_2 = 4*Constants.SCREEN_WIDTH/5;

        player = new Helminth(new Rect(100, 100, 500, 550));
        playerPoint = new Point(Constants.SCREEN_WIDTH/2, Constants.PLAYER_Y);
        player.update(playerPoint);

        renewObstacleManager();
    }

    public void reset(){
        playerPoint = new Point(Constants.SCREEN_WIDTH/2, Constants.PLAYER_Y);
        player.update(playerPoint);

        renewObstacleManager();

        movingPlayer = false;
    }

    private void renewObstacleManager(){
        obstacleManager = new ObstacleManager(400, 300, player);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        player.draw(canvas);
        obstacleManager.draw(canvas);

        if(gameOver){
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.BLACK);
            drawCenterText(canvas, paint, "Helminth's dead");
        }
    }

    private void drawCenterText(Canvas canvas, Paint paint, String text){
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public void terminate() {
        SceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void update() {
        if(!gameOver){
            player.update(playerPoint);
            obstacleManager.update();

            /*
            if(obstacleManager.playerCollide(player)){
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
            }

             */
        }
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(!gameOver){
                    movingPlayer = true;
                    touchStartX = event.getX();
                }
                if(gameOver && System.currentTimeMillis() - gameOverTime >= 2000){
                    reset();
                    gameOver = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                movingPlayer = false;
                float deltaX = event.getX() - touchStartX;
                if(deltaX > 5){ // right
                    moveHelminth("right");
                }else if(deltaX < -5){ // left
                    moveHelminth("left");
                }
                break;
        }
    }

    private void moveHelminth(String direction){
        switch(player.getCurrentHelminthPos()){ // 0 - left, 1 - center, 2 - right
            case 0:
                if(direction.equals("right")){
                    playerPoint.set(Constants.PLAYER_X_1, Constants.PLAYER_Y);
                    player.setCurrentHelminthPos(1);
                }
                break;
            case 1:
                if(direction.equals("right")){
                    playerPoint.set(Constants.PLAYER_X_2, Constants.PLAYER_Y);
                    player.setCurrentHelminthPos(2);
                }else if(direction.equals("left")){
                    playerPoint.set(Constants.PLAYER_X_0, Constants.PLAYER_Y);
                    player.setCurrentHelminthPos(0);
                }
                break;
            case 2:
                if(direction.equals("left")){
                    playerPoint.set(Constants.PLAYER_X_1, Constants.PLAYER_Y);
                    player.setCurrentHelminthPos(1);
                }
                break;
            default: break;
        }
    }
}