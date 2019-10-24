package com.example.egorhelminth_surfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Gosha implements GameObject {
    private Bitmap goshaBitmap;
    private boolean isVisible;
    private Rect rectangle;
    private int sideSize;
    private String way;

    private long startTime;
    private long startStayTime;

    public Gosha(){
        BitmapFactory bf = new BitmapFactory();
        this.goshaBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.gosha_privet);
        this.isVisible = false;

        this.sideSize = 1200;

        this.rectangle = new Rect(-sideSize, Constants.SCREEN_HEIGHT - sideSize, 0, Constants.SCREEN_HEIGHT);
        this.way = "right";
    }

    public void setVisibity(){
        if(!isVisible){
            isVisible = true;
            startTime = System.currentTimeMillis();
        }
    }

    @Override
    public void update() {
        if(isVisible){
            if(startTime < Constants.INIT_TIME)
                startTime = Constants.INIT_TIME;
            int elapsedTime = (int)(System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
            float speed = (float) Constants.SCREEN_HEIGHT/10000.0f;

            if(way.equals("right")){
                rectangle.left += speed * elapsedTime;
                rectangle.right += speed * elapsedTime;
                if (rectangle.left >= 0){
                    startStayTime = System.currentTimeMillis();
                    way = "stay";
                }
            }else if(way.equals("left")){
                rectangle.left -= speed * elapsedTime;
                rectangle.right -= speed * elapsedTime;
                if (rectangle.right <= 0){
                    way = "right";
                    isVisible = false;
                }
            }else if(way.equals("stay")){
                if(System.currentTimeMillis() - startStayTime > 4000){
                    way = "left";
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if(isVisible){
            Paint alphaPaint = new Paint();
            alphaPaint.setAlpha(100);
            canvas.drawBitmap(goshaBitmap, null, rectangle, alphaPaint);
        }
    }
}
