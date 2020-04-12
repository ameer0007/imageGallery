package com.example.galleryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView=findViewById(R.id.imf_full);
        int img_id=getIntent().getExtras().getInt("img_id");
        imageView.setImageResource(img_id);

    }
}
