package com.example.egorhelminth_surfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Obstacle implements GameObject {
    private Rect rectangle;
    private Bitmap obstacleBitmap;
    private String obstacleType;

    public Rect getRectangle(){
        return rectangle;
    }

    public void incrementY(float y){
        rectangle.top += y;
        rectangle.bottom += y;
    }

    public Obstacle(int pathX, int obstacleY, String obstacleType, int obstacleSize){
        this.rectangle = new Rect(0, 0, obstacleSize, obstacleSize);
        this.obstacleType = obstacleType;

        int obstacleX = 0;
        switch(pathX){ // 0, 1, 2
            case 0: obstacleX = Constants.PLAYER_X_0; break;
            case 1: obstacleX = Constants.PLAYER_X_1; break;
            case 2: obstacleX = Constants.PLAYER_X_2; break;
        }

        rectangle.set(obstacleX - rectangle.width()/2, obstacleY - rectangle.height()/2, obstacleX + rectangle.width()/2, obstacleY + rectangle.height()/2);

        setBitmap();
    }

    public String getObstacleType(){
        return obstacleType;
    }

    private void setBitmap(){
        BitmapFactory bf = new BitmapFactory();
        if(obstacleType.equals("shuba")){
            obstacleBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.shuba);
        }else if(obstacleType.equals("shoe")){
            obstacleBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.shoe);
        }else if(obstacleType.equals("tablette")){
            obstacleBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.tablette);
        }else if(obstacleType.equals("meat")){
            Random rand = new Random();
            int meatType = rand.nextInt(2);
            switch(meatType){
                case 0:
                    obstacleBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.meat1);
                    break;
                case 1:
                    obstacleBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.meat2);
                    break;
                case 2:
                    obstacleBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.meat3);
                    break;
                default: System.out.println("Meat skin error"); break;
            }
        }
    }

    public boolean playerCollide(Helminth player){
        return Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(obstacleBitmap, null, rectangle, new Paint());
    }

    @Override
    public void update() {

    }
}
