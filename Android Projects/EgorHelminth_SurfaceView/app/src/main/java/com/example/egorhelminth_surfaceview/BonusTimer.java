package com.example.egorhelminth_surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BonusTimer implements GameObject {
    private long startTime;
    private long endTime;
    private int color;
    private boolean isActive;
    private int xPos;
    private int yPos;
    private Helminth player;
    private String timerType;

    public BonusTimer(int xPos, int yPos, int color, Helminth player, String timerType, long endTimeInMilles){
        this.color = color;
        isActive = false;
        this.xPos = xPos;
        this.yPos = yPos;
        this.player = player;
        this.timerType = timerType;
        this.endTime = endTimeInMilles;
    }

    public void start(){
        startTime = System.currentTimeMillis();
        isActive = true;
    }

    @Override
    public void update() {
        if(isActive){
            if(System.currentTimeMillis() >= (endTime + startTime)){
                isActive = false;
                if (timerType.equals("shoe")){
                    player.turnOffImmortality();
                }else if(timerType.equals("shuba")){
                    player.turnOffInShuba();
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if(isActive){
            double deltaTime = (endTime - (System.currentTimeMillis() - startTime))/1000.0;
            int seconds = (int)Math.floor(deltaTime);
            String minutesStr = "00";
            int minutes = 0;
            if(seconds > 60){
                minutes = (int)Math.floor(seconds/60.0);
                seconds = seconds - minutes*60;
                if(minutes < 10){
                    minutesStr = "0" + minutes;
                }else{
                    minutesStr = "" + minutes;
                }
            }
            int centiseconds = (int)Math.round((deltaTime - seconds - minutes*60) * 100);
            String secondsStr;
            if (seconds < 10){
                secondsStr = "0" + seconds;
            }else{
                secondsStr = seconds + "";
            }

            Paint paint = new Paint();
            paint.setColor(color);
            paint.setTextSize(80);
            canvas.drawText(minutesStr + ":" + secondsStr + ":" + centiseconds, xPos, yPos, paint); // + paint.descent() - paint.ascent()
        }
    }
}
