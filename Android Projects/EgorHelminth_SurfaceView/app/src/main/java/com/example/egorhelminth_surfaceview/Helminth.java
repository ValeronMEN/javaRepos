package com.example.egorhelminth_surfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Helminth implements GameObject {
    private Rect rectangle;

    private Bitmap[] helminthStates;
    private int currentHelminthState;

    private int currentHelminthPos;

    public Helminth(Rect rectangle){
        this.rectangle = rectangle;
        currentHelminthState = 0;
        currentHelminthPos = 1;

        BitmapFactory bf = new BitmapFactory();
        Bitmap helminth_simple = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.helminth_simple);
        Bitmap helminth_shoe = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.helminth_shoe);
        Bitmap helminth_shuba = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.helminth_shuba);

        helminthStates = new Bitmap[]{helminth_simple, helminth_shoe, helminth_shuba};
    }

    public Rect getRectangle(){
        return rectangle;
    }

    public int getCurrentHelminthPos(){
        return currentHelminthPos;
    }

    public void setCurrentHelminthPos(int pos){
        currentHelminthPos = pos;
    }

    public int getCurrentHelminthState(){
        return currentHelminthState;
    }

    // 0 - simple, 1 - shoe, 2 - shuba
    public void setCurrentHelminthState(int state){
        if(state < 0 || state > 2){
            System.out.println("State error");
            return;
        }
        currentHelminthState = state;
    }

    @Override
    public void draw(Canvas canvas) {
        //Paint paint = new Paint();
        //paint.setColor(color);
        //canvas.drawRect(rectangle, paint);
        //animManager.draw(canvas, rectangle);
        canvas.drawBitmap(helminthStates[currentHelminthState], null, rectangle, new Paint());
    }

    @Override
    public void update() {

    }

    public void update(Point point){
        rectangle.set(point.x - rectangle.width()/2, point.y - rectangle.height()/2, point.x + rectangle.width()/2, point.y + rectangle.height()/2);
    }
}
