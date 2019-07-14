package com.example.klaus.nyco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void show_profile(View view) {
        Intent profile = new Intent(this, my_profile.class);
        startActivity(profile);
    }

    public void show_about(View view) {
        Intent about = new Intent(this, andela_learning.class);
        startActivity(about);
    }
}
