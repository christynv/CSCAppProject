package com.example.mixnmatch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GalleryActivity extends Activity{
	
	 GridView MyGrid;
	   
	   @Override
	   public void onCreate(Bundle savedInstanceState){
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.gallery_layout);

	      MyGrid = (GridView)findViewById(R.id.gridlayout);
	      MyGrid.setAdapter(new ImageAdapter(this));
	   }
	   
	   
	   public class ImageAdapter extends BaseAdapter {
	      Context MyContext;
	      
	      public ImageAdapter(Context adapterContext)
	      {
	         MyContext = adapterContext;
	      }
	      
	      @Override
	      public int getCount() 
	      {
	         return 15;
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
	            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            iv.setImageResource(R.drawable.burberry_woman);
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
