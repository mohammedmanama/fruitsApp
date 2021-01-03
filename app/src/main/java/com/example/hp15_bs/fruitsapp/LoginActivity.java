package com.example.hp15_bs.fruitsapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Intent intent = getIntent();
        final String phone = intent.getStringExtra("phone");
        final String password = intent.getStringExtra("password");


        final EditText phoneNumEd = findViewById(R.id.phoneEd);
        final EditText passwordLoginEd = findViewById(R.id.passwordEd);
        Button login = findViewById(R.id.loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = phoneNumEd.getText().toString();
                String passwordLogin = passwordLoginEd.getText().toString();
                if((phoneNum != null && !phoneNum.trim().equals("") && phoneNum.equals(phone)) && password != null && !password.trim().equals("") && passwordLogin.equals(password)){
                    Intent login = new Intent(getApplicationContext(),MainActivity.class);
                    MyHelper helper = new MyHelper(getApplicationContext(),"products",1);
                    SQLiteDatabase db = helper.getWritableDatabase();
                    db.execSQL("insert into products(photo,name,number,price) values('lemon' , 1 ,5.5)");
                    db.execSQL("insert into products(photo,name,number,price) values('watermelon' , 1 ,8.3)");
                    db.execSQL("insert into products(photo,name,number,price) values('tomatoes' , 1 ,4)");
                    db.execSQL("insert into products(photo,name,number,price) values('orange' , 1 ,6)");
                    db.execSQL("insert into products(photo,name,number,price) values('peache' , 1 ,6.2)");
                    db.execSQL("insert into products(photo,name,number,price) values('strawberries' , 1 ,8)");
                    db.execSQL("insert into products(photo,name,number,price) values('cream' , 1 ,7)");
                    db.execSQL("insert into products(photo,name,number,price) values('grape' , 1 ,9.6)");
                    db.execSQL("insert into products(photo,name,number,price) values('banana' , 1 ,5)");
                    db.close();
                    startActivity(login);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Please confirm your phone number or password",Toast.LENGTH_SHORT);
                    toast.show();
                }
                }
        });


    }
}
