package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name,gmail,pass;
    Button regi;
    Boolean checked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.name);
        gmail=findViewById(R.id.mail);
        pass=findViewById(R.id.pass);
        regi=findViewById(R.id.reg);

    }

    public void onclick(View view) {
        checked=checkedall();
        if (checked){
            Toast.makeText(this, "succesfull", Toast.LENGTH_SHORT).show();
        }
    }
    private Boolean checkedall(){
        if(name.length()==0){
            name.setError("name required");
            return false;
        }
        if (gmail.length()==0){
            gmail.setError("enter email");
            return false;
        }
        else {
            String s=gmail.getText().toString();
            String ch="[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+";
            if (!s.matches(ch)){
                gmail.setError("invalid format");
                return false;
            }
        }
        return true;
    }

    public void regs(View view) {
        Intent i=new Intent(MainActivity2.this,MainActivity.class);
        String in=gmail.getText().toString();
        String pa=pass.getText().toString();
        i.putExtra("gmail",in);
        i.putExtra("pass",pa);
        startActivity(i);
    }
}