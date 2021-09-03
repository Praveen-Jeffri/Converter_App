package com.google.converterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView conimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        conimage=findViewById(R.id.cimage);

        Intent intent = new Intent(SplashScreen.this,Selection_screen.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                conimage.animate().translationY(-1600).setDuration(1000);
            startActivity(intent);
            finish();
            }
        },3000);

    }
}