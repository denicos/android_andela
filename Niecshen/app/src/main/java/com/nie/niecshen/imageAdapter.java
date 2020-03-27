package com.nie.niecshen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class imageAdapter extends BaseAdapter {

    private Context mContext;

    //constructor
    public imageAdapter(Context c){
        mContext = c;
    }

    public int getCount(){
        return mThumbIds.length;
    }
    public Object getItem(int position){
        return 0;
    }
    public long getItemId(int position){
        return 0;
    }
    //create a new imageView for each item referenced by the adapter

    public View getView(int position , View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else{
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    //keep all images in array
    public Integer[] mThumbIds = {
      R.drawable.nie, R.drawable.nie1, R.drawable.nie2,
      R.drawable.shen1, R.drawable.nie3, R.drawable.nie4,
            R.drawable.nie5, R.drawable.nie6,   R.drawable.nie7,
            R.drawable.nie8, R.drawable.shen2, R.drawable.shen3,
            R.drawable.shen4, R.drawable.shen5, R.drawable.shen6,
            R.drawable.shen7,R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.eight, R.drawable.ten, R.drawable.eleven,
    };
}
