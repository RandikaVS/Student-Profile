package com.user.student_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView WelcomeScreenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WelcomeScreenText = findViewById(R.id.WelcomeScreenText);

        WelcomeScreenText.animate().translationX(1000).setDuration(1000).setStartDelay(4500);

        Thread thread = new Thread(){

            public void run(){

                try {
                    Thread.sleep(5500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(MainActivity.this,LoginScreen.class);
                    startActivity(intent);

                }
            }
        };
        thread.start();
    }
}