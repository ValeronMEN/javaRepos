package com.example.egorhelminth_surfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Diablo implements GameObject {
    private Rect rectangle;
    private boolean isVisible;
    private Bitmap diabloBitmap;
    private int endSize;
    private long startTime;

    public Diablo(){
        BitmapFactory bf = new BitmapFactory();
        this.diabloBitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.diablo);
        this.isVisible = false;

        this.rectangle = new Rect(0, 0, 100, 125);
        setInCenter();

        if(Constants.SCREEN_HEIGHT > Constants.SCREEN_WIDTH){
            this.endSize = Constants.SCREEN_WIDTH;
        }else{
            this.endSize = Constants.SCREEN_HEIGHT;
        }
    }

    private void setInCenter(){
        rectangle.set(Constants.SCREEN_WIDTH/2 - rectangle.width()/2, Constants.SCREEN_HEIGHT/2 - rectangle.height()/2,
                Constants.SCREEN_WIDTH/2 + rectangle.width()/2, Constants.SCREEN_HEIGHT/2 + rectangle.height()/2);
    }

    @Override
    public void draw(Canvas canvas) {
        if(isVisible){
            Paint alphaPaint = new Paint();
            alphaPaint.setAlpha(100);
            canvas.drawBitmap(diabloBitmap, null, rectangle, alphaPaint);
        }
    }

    @Override
    public void update() {
        if(isVisible){
            if(startTime < Constants.INIT_TIME)
                startTime = Constants.INIT_TIME;
            int elapsedTime = (int)(System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
            float speed = (float) Constants.SCREEN_HEIGHT/2000.0f;

            rectangle.right += speed * elapsedTime;
            rectangle.bottom += 1.25 * speed * elapsedTime;

            setInCenter();

            if(rectangle.height() >= 2.5*endSize || rectangle.width() >= 2.5*endSize){
                isVisible = false;
            }
        }
    }

    public void makeActive(){
        if(!isVisible){
            this.rectangle = new Rect(0, 0, 100, 100);
            setInCenter();
            isVisible = true;
            startTime = System.currentTimeMillis();
        }
    }
}
