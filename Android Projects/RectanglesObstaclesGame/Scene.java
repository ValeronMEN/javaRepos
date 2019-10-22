package com.example.egorhelminths;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Scene {
    public void draw(Canvas canvas);
    public void update();
    public void recieveTouch(MotionEvent event);
    public void terminate();
}
