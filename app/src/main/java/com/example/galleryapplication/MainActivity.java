package com.example.galleryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> mImageIds =new ArrayList<>(Arrays.asList(R.drawable.audicar,R.drawable.bmw,R.drawable.careight
    ,R.drawable.carfive,R.drawable.carfour,R.drawable.carnine,R.drawable.carone,R.drawable.carsix,R.drawable.carten
    ,R.drawable.farrie,R.drawable.cartrwo,R.drawable.carthree));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView=findViewById(R.id.myGrid);
        gridView.setAdapter(new ImageAdapter(mImageIds,this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos=mImageIds.get(position);
                ShowDialogBox(item_pos);

            }
        });

    }
    public void ShowDialogBox(final int item_pos){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        TextView image_name=dialog.findViewById(R.id.tex_img_name);
        ImageView Image=dialog.findViewById(R.id.img1);
        Button btn=dialog.findViewById(R.id.btn_full);
        Button btn_Close=dialog.findViewById(R.id.btn_close);
        String title =getResources().getResourceName(item_pos);
        int index=title.indexOf("/");
        String name =title.substring(index+1,title.length());
        image_name.setText(name);
        Image.setImageResource(item_pos);
        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("img_id",item_pos);
        startActivity(intent);
    }
});
                       dialog.show();
    }

}
