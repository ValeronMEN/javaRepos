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

    private boolean isVisible;

    public Obstacle(int pathX, int obstacleY, String obstacleType, int obstacleSize){
        this.rectangle = new Rect(0, 0, obstacleSize, obstacleSize);
        this.obstacleType = obstacleType;
        this.isVisible = true;

        int obstacleX = 0;
        switch(pathX){ // 0, 1, 2
            case 0: obstacleX = Constants.PLAYER_X_0; break;
            case 1: obstacleX = Constants.PLAYER_X_1; break;
            case 2: obstacleX = Constants.PLAYER_X_2; break;
            default: System.out.println("Path X error"); break;
        }

        rectangle.set(obstacleX - rectangle.width()/2, obstacleY - rectangle.height()/2, obstacleX + rectangle.width()/2, obstacleY + rectangle.height()/2);

        setBitmap();
    }

    public Rect getRectangle(){
        return rectangle;
    }

    public void incrementY(float y){
        rectangle.top += y;
        rectangle.bottom += y;
    }

    public void setVisibility(boolean visibility){
        this.isVisible = visibility;
    }

    public boolean getVisibility(){
        return this.isVisible;
    }

    public String getObstacleType(){
        return obstacleType;
    }

    private void setBitmap(){
        if(obstacleType.equals("shuba")){
            obstacleBitmap = Constants.shuba;
        }else if(obstacleType.equals("shoe")){
            obstacleBitmap = Constants.shoe;
        }else if(obstacleType.equals("tablette")){
            obstacleBitmap = Constants.tablette;
        }else if(obstacleType.equals("meat")){
            Random rand = new Random();
            int meatType = rand.nextInt(2);
            switch(meatType){
                case 0:
                    obstacleBitmap = Constants.meat1;
                    break;
                case 1:
                    obstacleBitmap = Constants.meat2;
                    break;
                case 2:
                    obstacleBitmap = Constants.meat3;
                    break;
                default: System.out.println("Meat skin error"); break;
            }
        }
    }

    public int playerCollide(Helminth player){
        if(isVisible && intersectRects(rectangle, player.getRectangle())){
            switch(obstacleType){
                case "meat": return 1;
                case "shoe": return 2;
                case "shuba": return 3;
                case "tablette": return -1;
            }
        }
        return 0;
    }

    //Rect.intersects(rectangle, player.getRectangle())
    private boolean intersectRects(Rect obstacleRect, Rect playerRect){
        if(playerRect.contains(obstacleRect.left, obstacleRect.top) ||
                playerRect.contains(obstacleRect.left, obstacleRect.bottom) ||
                playerRect.contains(obstacleRect.right, obstacleRect.top) ||
                playerRect.contains(obstacleRect.right, obstacleRect.bottom)){
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        if(isVisible)
            canvas.drawBitmap(obstacleBitmap, null, rectangle, new Paint());
    }

    @Override
    public void update() {

    }
}
