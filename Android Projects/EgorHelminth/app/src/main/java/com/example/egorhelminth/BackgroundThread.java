package com.example.egorhelminth;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

public class BackgroundThread extends Thread {
    private Activity activity;

    @Override
    public void run() {
        View view1 = activity.findViewById(R.id.path1);
        View view2 = activity.findViewById(R.id.path2);

        translatePath(view1, view2);
    }

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    private void translatePath(View view1, View view2){
        TranslateAnimation anim1 = new TranslateAnimation(0, 0, 0, 1920);
        anim1.setDuration(Constants.BACKGROUND_TIME);
        TranslateAnimation anim2 = new TranslateAnimation(0, 0, -1920, 0);
        anim2.setDuration(Constants.BACKGROUND_TIME);
        anim1.setRepeatCount(Animation.INFINITE);
        anim2.setRepeatCount(Animation.INFINITE);
        anim1.setInterpolator(new LinearInterpolator());
        anim2.setInterpolator(new LinearInterpolator());

        view1.startAnimation(anim1);
        view2.startAnimation(anim2);
    }
}
