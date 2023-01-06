package com.example.toggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img,img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img =(ImageView) findViewById(R.id.img1);
        img1 =(ImageView) findViewById(R.id.img2);

        img.setOnClickListener(this);
        img1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == img){
            img.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
        }
        else {
            img1.setVisibility(View.GONE);
            img.setVisibility(View.VISIBLE);

        }
    }
}