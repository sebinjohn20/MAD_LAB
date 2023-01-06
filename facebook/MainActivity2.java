package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.email);
        t2=findViewById(R.id.Password);
        Intent intent=getIntent();
        String val1=intent.getStringExtra("email");
        String val2=intent.getStringExtra("pass");
        t1.setText("Email: "+val1);

        t2.setText("Password: "+val2);
    }
}