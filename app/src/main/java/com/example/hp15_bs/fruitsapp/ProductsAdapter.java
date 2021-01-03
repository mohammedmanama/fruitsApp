package com.example.hp15_bs.fruitsapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductsAdapter extends CursorAdapter {

    public ProductsAdapter(Context context, Cursor c) {
        super(context, c,1);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_products , parent , false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView photoPro = view.findViewById(R.id.photoPro);
        TextView namePro = view.findViewById(R.id.namePro);
        TextView counter = view.findViewById(R.id.counter);
        TextView priceTv = view.findViewById(R.id.priceTv);

        int photo = cursor.getInt(cursor.getColumnIndex("photo"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        int number = cursor.getInt(cursor.getColumnIndex("number"));
        double price = cursor.getDouble(cursor.getColumnIndex("price"));

        photoPro.setImageResource(photo);
        namePro.setText(name);
        counter.setText(number);
        priceTv.setText(price+"");

    }
}
