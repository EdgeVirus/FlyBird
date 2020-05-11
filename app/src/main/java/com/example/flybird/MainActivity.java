package com.example.flybird;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //屏幕的宽度
    private int screenWidth;
    //帧动画
    private ImageView bird;
    //播放帧画
    private AnimationDrawable birdDrawable;
    //属性动画
    private AnimatorSet birdAnimatorSet;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取屏幕宽度
        getWindowWidth();
        //初始化
        bird = findViewById(R.id.bird);
        //设置控件的初始位置
        bird.setTranslationX(-screenWidth);
        //获取帧动画的对象
        birdDrawable = (AnimationDrawable) bird.getDrawable();
        //属性动画
        birdAnimatorSet = new AnimatorSet();
        ObjectAnimator bridObjectAnimatorR = ObjectAnimator.ofFloat(bird,"translationX",screenWidth);
        bridObjectAnimatorR.setDuration(30*1000);
        bridObjectAnimatorR.setInterpolator(new LinearInterpolator());
        bridObjectAnimatorR.setRepeatMode(ValueAnimator.RESTART);
        bridObjectAnimatorR.setRepeatCount(ValueAnimator.INFINITE);
        birdAnimatorSet.play(bridObjectAnimatorR);
        birdAnimatorSet.start();
        birdDrawable.start();
    }


    private void getWindowWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;

    }
}
