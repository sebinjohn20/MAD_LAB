package com.example.co_5_database;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eid,ename,eplace;
    Button bins,bsel,bup,bdel,bclr;
    AlertDialog.Builder builder;
    SQLiteDatabase db;
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eid = findViewById(R.id.id);
        ename = findViewById(R.id.name);
        eplace = findViewById(R.id.place);
        bins = findViewById(R.id.insert);
        bsel = findViewById(R.id.select);
        bup = findViewById(R.id.update);
        bdel = findViewById(R.id.delete);
        bclr = findViewById(R.id.clear);
        builder = new AlertDialog.Builder(this);

        try{
            db = openOrCreateDatabase("empdb",MODE_PRIVATE,null);
            db.execSQL("create table employee(id integer primary key,name Text,place Text)");
            Toast.makeText(getApplicationContext(),"Created Successffully",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){

        }
        
        bins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    db.execSQL("insert into employee values("+eid.getText().toString()+",'"+ename.getText().toString()+"','"+eplace.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(),"Record Inserted Successfully",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error in Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bclr.callOnClick();

        bsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = db.rawQuery("select * from employee", null);
                if(c.getCount()==0){
                    Toast.makeText(getApplicationContext(), "No such Record!", Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer b = new StringBuffer();
                    while(c.moveToNext()){
                        b.append("ID : " + c.getString(0) + "\n");
                        b.append("NAME : " + c.getString(1) + "\n");
                        b.append("PLCE : " + c.getString(2) + "\n");
                    }
                    Toast.makeText(getApplicationContext(),b.toString(),Toast.LENGTH_LONG).show();
                    builder.setMessage(b.toString());
                    AlertDialog alert = builder.create();
                    alert.setTitle("---EMPLOYEE DATA---");
                    alert.show();
                }
            }
        });

        bup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("update employee set name='"+ename.getText().toString()+"',place='"+eplace.getText().toString()+"' where id="+eid.getText().toString()+"");
                Toast.makeText(getApplicationContext(), "---Updated---", Toast.LENGTH_SHORT).show();
            }
        });

        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("delete from employee where id="+eid.getText().toString());
                Toast.makeText(getApplicationContext(), "---Item Deleted---", Toast.LENGTH_SHORT).show();
            }
        });

        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eid.setText("");
                ename.setText("");
                eplace.setText("");
            }
        });
        bclr.callOnClick();
    }
}




