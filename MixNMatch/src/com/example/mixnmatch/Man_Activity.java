package com.example.mixnmatch;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Man_Activity extends Activity{
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;
	public static final int MEDIA_TYPE_IMAGE = 1;
	
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.man_layout);

    ViewPager toppager = (ViewPager)findViewById( R.id.mentoppager );
    MyPagerAdapter topadapter = new MyPagerAdapter();
    toppager.setAdapter(topadapter);

    toppager.setOffscreenPageLimit(topadapter.getCount());

    toppager.setPageMargin(15);
 
    ViewPager botpager = (ViewPager)findViewById( R.id.menbottompager );
    MyPagerAdapter botadapter = new MyPagerAdapter();
    botpager.setAdapter(botadapter);

    botpager.setOffscreenPageLimit(botadapter.getCount());
  
    botpager.setPageMargin(15);
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


// Nothing special about this adapter, just throwing up colored views for
// demo
private class MyPagerAdapter extends PagerAdapter{

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        TextView view = new TextView(Man_Activity.this);
        view.setText("Item " + position);
        view.setGravity(Gravity.CENTER);
        view.setBackgroundColor(Color.argb(255, position * 50,
                position * 10, position * 50));

        container.addView(view);
        return view;
                                 }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
                {
        container.removeView((View) object);}

    @Override
    public int getCount(){
     return 10;
             }

    @Override
    public boolean isViewFromObject(View view, Object object)
         {
        return (view == object);
               }}}
