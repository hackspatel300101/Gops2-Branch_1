package com.example.chintu.Gops;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private static int splash_time_out = 3000;
    ImageView iv;
    TextView tv, tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv = findViewById(R.id.splash);
        tv = findViewById(R.id.title);
        tv1 = findViewById(R.id.title1);
        AnimationUtils animationUtils = new AnimationUtils();
        Animation animation = animationUtils.loadAnimation(Splash.this, R.anim.fade_in);
        Animation animation1 = animationUtils.loadAnimation(Splash.this, R.anim.move);
        Animation animation2 = animationUtils.loadAnimation(Splash.this, R.anim.slide_down);
        tv.startAnimation(animation);
        iv.startAnimation(animation1);
        tv1.startAnimation(animation2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(Splash.this, Login.class);
                startActivity(i);
                finish();
            }
        }, splash_time_out);

    }
}
