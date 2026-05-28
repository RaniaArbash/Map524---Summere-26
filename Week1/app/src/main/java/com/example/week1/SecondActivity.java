package com.example.week1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText countryView;
    Button  saveButton, change_img;
    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        countryView = findViewById(R.id.countrytext);// R.java is an auto generated file
        saveButton = findViewById(R.id.save);
        change_img = findViewById(R.id.change_img);
        map = findViewById(R.id.map);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytag","save button clicked");
                String country =   countryView.getText().toString();
                if (!country.isEmpty()){
                    Log.d("mytag","My country is " + country);
                }
            }
        });

        change_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = getResources().getDrawable(R.drawable.ball);
                map.setImageDrawable(drawable);
            }
        });

    }
}