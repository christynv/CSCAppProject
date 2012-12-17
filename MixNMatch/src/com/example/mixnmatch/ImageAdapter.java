package com.example.mixnmatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageAdapter extends BaseAdapter {
    Context mContext;
    Integer [] pics;
    
    public ImageAdapter(Integer [] b, Context c)
    {
       pics = b;
       mContext = c;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {   	      	          
          ImageView iv = new ImageView(mContext);
          iv.setImageResource(pics[position]);
          iv.setLayoutParams(new GridView.LayoutParams(300, 300));
          iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);      
       return iv;
    }

    @Override
    public int getCount() 
    {
       return pics.length;
    }

    @Override
    public Object getItem(int arg0) {
       // TODO Auto-generated method stub
       return pics[arg0];
    }

    @Override
    public long getItemId(int arg0) {
       // TODO Auto-generated method stub
       return 0;
    }
    
 }
