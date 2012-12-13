package com.example.mixnmatch;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeMainActivity extends Activity {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;
	public static final int MEDIA_TYPE_IMAGE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(true);
	    actionBar.setDisplayShowHomeEnabled(true);
	    	    
	    Tab tab = actionBar.newTab().setText(R.string.tab1).setTabListener
	    		(new TabListener<MenFragment>(this,"men", MenFragment.class));
	    actionBar.addTab(tab);

	    tab = actionBar.newTab().setText(R.string.tab2).setTabListener
	    		(new TabListener<WomenFragment>(this,"women", WomenFragment.class));
	    actionBar.addTab(tab);
	    
	    tab = actionBar.newTab().setText(R.string.tab3).setTabListener
	    		(new TabListener<StyleFragment>(this,"style", StyleFragment.class));
	    actionBar.addTab(tab);
	    
	    this.setRequestedOrientation(
	    		ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_layout, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.photo:
				cameraStart();
				return true;
			case R.id.random:
				showToast();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	public void cameraStart()
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
		startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
		
	}
	private static Uri getOutputMediaFileUri(int type)
	{
		return Uri.fromFile(getOutputMediaFile(type));
	}
	private static File getOutputMediaFile(int type){
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.

	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "MyCameraApp");
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("MyCameraApp", "failed to create directory");
	            return null;
	        }
	    }

	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE){
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "IMG_"+ timeStamp + ".jpg");
	    } 
	    else {
	        return null;
	    }

	    return mediaFile;
	}
	private void showToast()
	{
		Context context = getApplicationContext();
		CharSequence text = "Randomizing...";
		int duration = Toast.LENGTH_SHORT;
		
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
	}
}
