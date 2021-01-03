package com.example.hp15_bs.fruitsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Person extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        final TextView personName = findViewById(R.id.personName);
        final TextView personPhone = findViewById(R.id.personPhone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        personName.setText(name);
        String phone = intent.getStringExtra("phone");
        personPhone.setText(phone);
        startActivityForResult(intent,2);

        ListView lv = findViewById(R.id.listView);
        View header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.person_header,null);
        lv.addHeaderView(header);

    }
}
