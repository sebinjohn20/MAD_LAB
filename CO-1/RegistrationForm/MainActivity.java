package com.example.registration_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first1, date1, last1, email1, password1;
    Button register1;
    RadioButton male1, female1, other1;
    boolean isAllFieldChecked = false;
    RadioGroup rp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first1 = findViewById(R.id.first);
        last1 = findViewById(R.id.last);
        date1 = findViewById(R.id.date);
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        male1 = findViewById(R.id.male);
        female1 = findViewById(R.id.female);
        other1 = findViewById(R.id.other);
        rp = findViewById(R.id.rd);
    }

    public void submit(View view) {
        isAllFieldChecked = CheckAllFields();
        if (isAllFieldChecked){
            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean CheckAllFields() {
        if (first1.length()==0) {
            first1.setError("First Name is required");
            return false;
        }
        if (last1.length()==0) {
            last1.setError("Last Name is required");
            return false;
        }
        if (email1.length()==0){
            email1.setError("Email is required");
            return false;
        }
        else{
            String s_mail=email1.getText().toString();
            String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+";
            if(!s_mail.matches(checkEmail)){
                email1.setError("Invalid Email!!");
                return false;
            }
        }
        if (date1.length()==0) {
            date1.setError("Date is requied");
            return false;
        }
        if (password1.length()==0) {
            password1.setError("password is requied");
            return false;
        }
        else if(password1.length()<8) {
            password1.setError("password must be minimum 8 charactors!");
            return false;
        }
        if (rp.getCheckedRadioButtonId() == -1) {
            other1.setError("Select gender");
            other1.requestFocus();
            return false;
        }
        return true;
    }
}