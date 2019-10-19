package com.example.egorhelminth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView helminth;
    private LinearLayout buttonsField;
    private ImageView buttonsImage;
    static private final int backgroundTime = 4000;
    static private final int deltaX = 300;
    static private final int movementTime = 40; //70
    boolean movementBlock = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_activity);

        buttonsImage = findViewById(R.id.buttonsImage);
        buttonsField = findViewById(R.id.buttonsField);
        int buttonsY = 1610;
        buttonsImage.setY(buttonsY);
        buttonsField.setY(buttonsY);

        helminth = findViewById(R.id.helminth_2);
        //helminth.setTranslationX(275); //205 for 250x250dp
        helminth.setX(275);
        helminth.setY(1050);

        View view1 = findViewById(R.id.path1);
        View view2 = findViewById(R.id.path2);

        translatePath(view1, view2);
    }

    private void translatePath(View view1, View view2){
        TranslateAnimation anim1 = new TranslateAnimation(0, 0, 0, 1920);
        anim1.setDuration(backgroundTime);
        TranslateAnimation anim2 = new TranslateAnimation(0, 0, -1920, 0);
        anim2.setDuration(backgroundTime);
        //anim1.setFillAfter(true);
        //anim2.setFillAfter(true);
        anim1.setRepeatCount(Animation.INFINITE);
        anim2.setRepeatCount(Animation.INFINITE);

        view1.startAnimation(anim1);
        view2.startAnimation(anim2);
    }

    public void moveLeft(View view){
        if(!movementBlock){
            TranslateAnimation anim;
            float y = helminth.getY();
            switch((int)(helminth.getX())){
                case (275-deltaX): break;
                case 275:
                    anim = new TranslateAnimation(0, -deltaX, 0, 0);
                    anim.setDuration(movementTime);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            movementBlock = true;
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            helminth.setX(275-deltaX);
                            movementBlock = false;
                        }
                    });
                    break;
                case (275+deltaX):
                    anim = new TranslateAnimation(0, -deltaX, 0, 0);
                    anim.setDuration(movementTime);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            movementBlock = true;
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            helminth.setX(275);
                            movementBlock = false;
                        }
                    });
                    break;
            }
        }
    }

    public void moveRight(View view){
        if(!movementBlock){
            TranslateAnimation anim;
            switch((int)(helminth.getX())){
                case (275-deltaX):
                    anim = new TranslateAnimation(0, deltaX, 0, 0);
                    anim.setDuration(movementTime);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            movementBlock = true;
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            helminth.setX(275);
                            movementBlock = false;
                        }
                    });
                    break;
                case 275:
                    anim = new TranslateAnimation(0, deltaX, 0, 0);
                    anim.setDuration(movementTime);
                    helminth.startAnimation(anim);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            movementBlock = true;
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            helminth.setX(275+deltaX);
                            movementBlock = false;
                        }
                    });
                    break;
                case (275+deltaX): break;
            }
        }
    }
}
