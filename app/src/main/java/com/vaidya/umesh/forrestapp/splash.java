package com.vaidya.umesh.forrestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {
    LinearLayout l1,l2;
    private TextView tv;
    Animation updown,downup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        l1 =(LinearLayout) findViewById(R.id.l1);
        l2 =(LinearLayout) findViewById(R.id.l2);
        tv=(TextView) findViewById(R.id.tv);
        updown = AnimationUtils.loadAnimation(this,R.anim.updown);
        downup = AnimationUtils.loadAnimation(this,R.anim.downup);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.updown);
        l1.setAnimation(updown);
        l2.setAnimation(downup);
        // l1.startAnimation(myanim) ;
        // l2.setAnimation(updown);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {

                Intent i =new Intent(splash.this ,login.class);
                startActivity(i);
                splash.this.finish();

            }

        }, 2000);

    }
}
