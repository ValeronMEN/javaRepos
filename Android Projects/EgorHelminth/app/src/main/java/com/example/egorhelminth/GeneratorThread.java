package com.example.egorhelminth;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GeneratorThread extends Thread {
    private Activity activity;
    private Queue<FloatingObject> foQueue;
    private int yLenght;
    private int animDuration;

    @Override
    public void run() {
        foQueue = new LinkedList<FloatingObject>();

        for(int i = 0; i < 15; i++) {
            FloatingObject fo = new FloatingObject(activity);
            foQueue.add(fo);
        }

        yLenght = 1920 + 500;
        animDuration = (int)Math.floor((Constants.BACKGROUND_TIME / 1920.0)) * yLenght;

        while(foQueue.size() != 0){
            try {
                activity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Random rand = new Random();
                        TranslateAnimation anim = new TranslateAnimation(0, 0, 0, yLenght);
                        anim.setDuration(animDuration);
                        anim.setFillAfter(true);
                        anim.setInterpolator(new LinearInterpolator());

                        FloatingObject foInstance = foQueue.poll();
                        foInstance.setFobjectType(1);
                        foInstance.setSide(rand.nextInt(2));

                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.WRAP_CONTENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT
                        );
                        layoutParams.height = (int) activity.getResources().getDimension(R.dimen.imageview_height);
                        layoutParams.width = (int) activity.getResources().getDimension(R.dimen.imageview_width);

                        RelativeLayout relLayout = activity.findViewById(R.id.relLayout);
                        relLayout.addView(foInstance, layoutParams);
                        //foQueue.add(fobject);
                        foInstance.startAnimation(anim);
                    }
                });
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setActivity(Activity activity){
        this.activity = activity;
    }
}
