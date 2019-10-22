package com.example.egorhelminth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView helminth;
    boolean movementBlock = false;
    int helminthPos = 1; // 0 - left, 1 - center, 2 - right

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_activity);

        ImageView buttonsImage = findViewById(R.id.buttonsImage);
        LinearLayout buttonsField = findViewById(R.id.buttonsField);
        int buttonsY = 1610;
        buttonsImage.setY(buttonsY);
        buttonsImage.setZ(Constants.TOP_Z);
        buttonsField.setY(buttonsY);

        helminth = findViewById(R.id.helminth_2);
        helminth.setX(275); //205 for 250x250dp
        helminth.setY(1050);
        helminth.setZ(Constants.TOP_Z);

        BackgroundThread backThread = new BackgroundThread();
        backThread.setActivity(this);

        GeneratorThread genThread = new GeneratorThread();
        genThread.setActivity(this);

        backThread.start();
        genThread.start();
    }

    private void generateExampleFobject(){
        FloatingObject fobject = new FloatingObject(this);
        fobject.setFobjectType(1);
        fobject.setSide(0);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.height = (int) getResources().getDimension(R.dimen.imageview_height);
        layoutParams.width = (int) getResources().getDimension(R.dimen.imageview_width);

        RelativeLayout relLayout = findViewById(R.id.relLayout);
        relLayout.addView(fobject, layoutParams);
    }

    public void moveLeft(View view){
        if(!movementBlock){
            TranslateAnimation anim;
            switch(helminthPos){
                case 0: break;
                case 1:
                    anim = new TranslateAnimation(0, -CONSTANT.DELTA_X, 0, 0);
                    anim.setDuration(Constants.MOVEMENT_TIME);
                    anim.setFillAfter(true);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) { movementBlock = true; }
                        @Override
                        public void onAnimationRepeat(Animation animation) { }
                        @Override
                        public void onAnimationEnd(Animation animation) { movementBlock = false; }
                    });
                    helminthPos = 0;
                    break;
                case 2:
                    anim = new TranslateAnimation(CONSTANT.DELTA_X, 0, 0, 0);
                    anim.setDuration(Constants.MOVEMENT_TIME);
                    anim.setFillAfter(true);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) { movementBlock = true; }
                        @Override
                        public void onAnimationRepeat(Animation animation) { }
                        @Override
                        public void onAnimationEnd(Animation animation) { movementBlock = false; }
                    });
                    helminthPos = 1;
                    break;
            }
        }
    }

    public void moveRight(View view){
        if(!movementBlock){
            TranslateAnimation anim;
            switch(helminthPos){
                case 0:
                    anim = new TranslateAnimation(-CONSTANT.DELTA_X, 0, 0, 0);
                    anim.setDuration(Constants.MOVEMENT_TIME);
                    anim.setFillAfter(true);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) { movementBlock = true; }
                        @Override
                        public void onAnimationRepeat(Animation animation) { }
                        @Override
                        public void onAnimationEnd(Animation animation) { movementBlock = false; }
                    });
                    helminthPos = 1;
                    break;
                case 1:
                    anim = new TranslateAnimation(0, CONSTANT.DELTA_X, 0, 0);
                    anim.setDuration(Constants.MOVEMENT_TIME);
                    anim.setFillAfter(true);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) { movementBlock = true; }
                        @Override
                        public void onAnimationRepeat(Animation animation) { }
                        @Override
                        public void onAnimationEnd(Animation animation) { movementBlock = false; }
                    });
                    helminthPos = 2;
                    break;
                case 2: break;
            }
        }
    }
}
