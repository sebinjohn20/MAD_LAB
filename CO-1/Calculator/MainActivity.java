package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_first,et_second,et_result;
    Button et_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_first=findViewById(R.id.n1);
        et_second=findViewById(R.id.n2);
        et_result=findViewById(R.id.result);
        et_submit=findViewById(R.id.submit_btn);
    }
    public void sum(View view){
        int num1 = Integer.parseInt(et_first.getText().toString());
        int num2 = Integer.parseInt(et_second.getText().toString());
        int sum = num1+num2;
        et_result.setText(sum+"");
    }
}