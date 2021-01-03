package com.example.hp15_bs.fruitsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ListView lv = findViewById(R.id.listView);
        View header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.cart_header,null);
        lv.addHeaderView(header);

        Button finish = findViewById(R.id.finishBtn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TheLast.class);
                startActivity(intent);
            }
        });

    }
}
