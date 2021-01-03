package com.example.hp15_bs.fruitsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper helper = new MyHelper(getApplicationContext(),"cartdb",1);
                SQLiteDatabase db = helper.getWritableDatabase();

                final ArrayList<products> selectedProduct = new ArrayList<>();

                final List<products>product = new ArrayList<>();
                Cursor cursor = db.rawQuery("select * from products", null);
                    ListView lv = findViewById(R.id.listView);
                    ProductsAdapter adapter = new ProductsAdapter(getApplicationContext(), cursor);
                    lv.setAdapter(adapter);
                    lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            CheckBox chk = view.findViewById(R.id.checkBox);
                            chk.setChecked(!chk.isChecked());
                            if(chk.isChecked()){
                                products p = product.get(position);
                                selectedProduct.add(p);
                            }else {
                                products p = product.get(position);
                                selectedProduct.remove(p);
                            }
                        }
                    });


                final TextView counter = findViewById(R.id.counter);
        final int[] number = {Integer.parseInt(counter.getText().toString())};
                ImageView plus = findViewById(R.id.plusIcon);
                    plus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            number[0]++;
                        }
                    });

                    ImageView minus = findViewById(R.id.minusIcon);
                    minus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            number[0]--;
                        }
                    });


                    ImageView cartIc = findViewById(R.id.cartIc);
                    cartIc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), Cart.class);
                            startActivity(intent);
                        }
                    });

                    View header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.main_header, null);
                    lv.addHeaderView(header);

                    ImageView personIc = findViewById(R.id.personIc);
                    personIc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), Person.class);
                            startActivity(intent);
                        }
                    });






         /*
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    int id = cursor.getInt(cursor.getColumnIndex("_id"));
                    int photo = cursor.getInt(cursor.getColumnIndex("photo"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int number = cursor.getInt(cursor.getColumnIndex("number"));
                    double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    products p = new products();
                    p.setId(id);
                    p.setPhoto(photo);
                    p.setName(name);
                    p.setNumber(number);
                    p.setPrice(price);
                    product.add(p);
                    cursor.moveToNext();
                }
                cursor.close();
                for(products p:product){
                    Log.d("ttt",p.getName());
                }
     */
                }
    }

