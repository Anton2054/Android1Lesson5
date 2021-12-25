package com.example.android1lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android1lesson5.first_fragment.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,new FirstFragment()).commit();
        }

    }
}