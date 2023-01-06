package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        e1=findViewById(R.id.name);
        e3=findViewById(R.id.email);
        e2=findViewById(R.id.phone);
        e4=findViewById(R.id.Password);
        e5=findViewById(R.id.Password2);
        create=findViewById(R.id.button);


    }

    public void onClick(View view) {

        boolean isAllFieldChecked=CheckAllFields();
        if (isAllFieldChecked){

        Toast.makeText(this, "CREATE ACCOUNT", Toast.LENGTH_SHORT).show();
    }
    }

    private boolean CheckAllFields() {
        if (e1.length() == 0) {
            e1.setError(" Name is required");
            return false;
        }
        if (e3.length() == 0) {
            e3.setError("phone is required");
            return false;
        }


        if (e2.length() == 0) {
            e2.setError("email is required");
            return false;
        } else {
            String s_mail = e2.getText().toString();
            String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+";
            if (!s_mail.matches(checkEmail)) {
                e2.setError("Invalid Email!!");
                return false;
            }
        }
            if (e4.length() == 0) {
                e4.setError("password is requied");
                return false;
            } else if (e4.length() < 8) {
                e4.setError("password must be minimum 8 charactors!");
                return false;
            }
            return true;
        }
    }

