package com.example.galleryapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<Integer> mthumbIds;
    private Context mContext;

    public ImageAdapter(List<Integer> mthumbIds, Context mContext) {
        this.mthumbIds = mthumbIds;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mthumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mthumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=(ImageView) convertView;
        if (imageView==null){
           imageView=new ImageView(mContext);
           imageView.setLayoutParams(new GridView.LayoutParams(350,450));
           imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageView.setImageResource(mthumbIds.get(position));
        return imageView;
    }
}
