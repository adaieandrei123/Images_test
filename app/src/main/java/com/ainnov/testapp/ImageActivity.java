package com.ainnov.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView imgName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name","error");

        imgName = findViewById(R.id.imgName);
        imgName.setText(name);
        imgName.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgName){
            finish();
        }
    }
}