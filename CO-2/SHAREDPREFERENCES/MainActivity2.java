package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2,t3;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.email);
        t3=findViewById(R.id.location);
        sp=getSharedPreferences("register",MODE_PRIVATE);

        Intent intent=getIntent();
        String val1=intent.getStringExtra("name");
        String val2=intent.getStringExtra("email");
        String val3=sp.getString("location","");

        t1.setText("NAME: "+val1);
        t2.setText("EMAIL: "+val2);
        t3.setText("LOCATION: "+val3);
    }
}