/**RICHARD LUU & CHRISTYN VASQUEZ**/
/** GALLERY ACTIVITY FOR WOMEN PAGE*/

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

public class WomenGalleryActivity extends Activity {
		GridView MyGrid;
	 
	   @Override
	   public void onCreate(Bundle savedInstanceState){
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.gallery_layout);

	      MyGrid = (GridView)findViewById(R.id.gridlayout);
	      MyGrid.setAdapter(new ImageAdapter(Images.womenImages, this));
	      MyGrid.setBackgroundColor(Color.WHITE);
	      MyGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,	long id){
             Intent i = new Intent(getApplicationContext(), WomanActivity.class);
             i.putExtra("id", position);
             startActivity(i);
             i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
             finish();
			}
	      }); 

		  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	   }
}
