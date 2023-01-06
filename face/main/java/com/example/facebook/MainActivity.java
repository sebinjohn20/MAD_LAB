package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,pass;
    Button login,create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.et1);
        pass=findViewById(R.id.et2);
       login=findViewById(R.id.bt1);
       create=findViewById(R.id.bt2);



    }

    public void register(View view) {
        Intent i =new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }

    public void login(View view) {

        Intent intent=getIntent();
        String v1=intent.getStringExtra("gmail");
        String v2=intent.getStringExtra("pass");


        String v3=email.getText().toString();
        String v4=pass.getText().toString();

        if (v1.matches(v3) && v2.matches(v4)){
            Toast.makeText(this, "login successfull", Toast.LENGTH_SHORT).show();
            Intent in=new Intent(MainActivity.this,MainActivity3.class);
            startActivity(in);
        }
        else{
            Toast.makeText(this, "login unsuccesfull", Toast.LENGTH_SHORT).show();


        }
    }
}