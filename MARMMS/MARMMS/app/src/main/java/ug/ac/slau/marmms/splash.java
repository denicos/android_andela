package ug.ac.slau.marmms;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Runnable after3secs = new Runnable() {
            @Override
            public void run() {
                nextActivity();
                finish();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(after3secs, 3000);
    }

    public void nextActivity(){
        Intent login_intent = new Intent(this, login.class);
        startActivity(login_intent);
    }
}
