package com.example.egorhelminth;

import android.app.Activity;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import java.util.PriorityQueue;
import java.util.Random;

public class GeneratorThread extends Thread {
    private Activity activity;
    private PriorityQueue<FloatingObject> foQueue;

    @Override
    public void run() {
        foQueue = new PriorityQueue<FloatingObject>();
        try{
            for(int i = 0; i < 15; i++) {
                foQueue.add(FloatingObject.class.newInstance());
            }
            generateBarrier();
        }
        catch(IllegalAccessException|InstantiationException err){

        }
        //FloatingObject fo = foQueue.poll();
    }

    private void generateBarrier(){
        try{
            Random rand = new Random();
            while(true){
                FloatingObject fobject = foQueue.poll();
                fobject.setFobjectType(1);
                fobject.setSide(rand.nextInt(2));

                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.height = (int) activity.getResources().getDimension(R.dimen.imageview_height);
                layoutParams.width = (int) activity.getResources().getDimension(R.dimen.imageview_width);

                RelativeLayout relLayout = activity.findViewById(R.id.relLayout);
                relLayout.addView(fobject, layoutParams);


                TranslateAnimation anim = new TranslateAnimation(0, 0, 0, 2400);
                anim.setDuration(12000);
                anim.setFillAfter(true);
                //foQueue.add(fobject);
                fobject.startAnimation(anim);

                Thread.sleep(5000);
            }
        }
        catch(InterruptedException err){

        }
    }

    public void setActivity(Activity activity){
        this.activity = activity;
    }
}
