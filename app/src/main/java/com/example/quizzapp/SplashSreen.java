package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class SplashSreen extends AppCompatActivity {

    private  int TimeSplash=3000;
    LottieAnimationView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);



        loading=findViewById(R.id.loadingLottie);
        loading.playAnimation();
        loading.setSpeed(2.0f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashSreen.this,MainActivity.class);
                startActivity(intent);
                loading.pauseAnimation();
                finish();
            }
        },TimeSplash);

    }
}