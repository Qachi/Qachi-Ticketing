package com.example.projectii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=5000;
    private TextView text_Splash;
    private ImageView splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        text_Splash = (TextView)findViewById(R.id.text_Splash);
        splash = (ImageView) findViewById(R.id.splash);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        text_Splash.startAnimation(animation);
        splash.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
