package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.Password);
        login = findViewById(R.id.button);

    }

    public void login(View view) {
        String s1 = email.getText().toString();
        String s2 = pass.getText().toString();
        if (s1.equals("sebinjohn") && s2.equals("sebin")) {
            Toast.makeText(this, "LOGIN SUCESS", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            String val2 = pass.getText().toString();

            String val1 = email.getText().toString();
            i.putExtra("email", val1);
            i.putExtra("pass", val2);
            startActivity(i);
        } else {
            Toast.makeText(this, "password and email invaild", Toast.LENGTH_SHORT).show();
        }

    }

    public void newuser(View view) {
        Intent i = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(i);
    }
}