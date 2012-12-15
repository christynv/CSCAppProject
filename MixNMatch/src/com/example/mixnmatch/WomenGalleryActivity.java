package com.example.mixnmatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mixnmatch.MenGalleryActivity.ImageAdapter;

public class WomenGalleryActivity extends Activity {
		GridView MyGrid;
	 
	   @Override
	   public void onCreate(Bundle savedInstanceState){
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.gallery_layout);

	      MyGrid = (GridView)findViewById(R.id.gridlayout);
	      MyGrid.setAdapter(new ImageAdapter(Images.womenImages));
	      MyGrid.setBackgroundColor(Color.WHITE);
	      
	      MyGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,	long id){
             // Sending image id to FullScreenActivity
             Intent i = new Intent(getApplicationContext(), ManActivity.class);
             // passing array index
             i.putExtra("id", position);
             startActivity(i);
			}
	      });

		  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	   }
	   
	   public class ImageAdapter extends BaseAdapter {
	      Context MyContext;
	      Integer [] pics;
	      
	      public ImageAdapter(Integer [] b)
	      {
	         pics = b;
	      }
	      
	      @Override
	      public int getCount() 
	      {
	         return pics.length;
	      }

	      @Override
	      public View getView(int position, View convertView, ViewGroup parent) 
	      {
	         View MyView = convertView;
	         
	         if ( convertView == null )
	         {
	                                /*we define the view that will display on the grid*/
	            
	            //Inflate the layout
	            LayoutInflater li = getLayoutInflater();
	            MyView = li.inflate(R.layout.gallery_frag, null);
	            	
	            // Add The Image!!!           
	            ImageView iv = (ImageView)MyView.findViewById(R.id.grid_item_image);
	            iv.setImageResource(pics[position]);
	            iv.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
	            iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
	           
	         }
	         
	         return MyView;
	      }

	      @Override
	      public Object getItem(int arg0) {
	         // TODO Auto-generated method stub
	         return null;
	      }

	      @Override
	      public long getItemId(int arg0) {
	         // TODO Auto-generated method stub
	         return 0;
	      }
	   }
}
