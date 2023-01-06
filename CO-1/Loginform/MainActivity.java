package com.example.login_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText EditUser,EditPass;
    Button BtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditUser=findViewById(R.id.txt_uname);
        EditPass=findViewById(R.id.txt_pwd);
        BtnLogin=findViewById(R.id.btn_login);
    }

    public void login_user(View view) {
        String s1=EditUser.getText().toString();
        String s2=EditPass.getText().toString();
        if (s1.equals("Sreeragtv") && s2.equals("sreerag"))
        {
            Toast.makeText(this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}