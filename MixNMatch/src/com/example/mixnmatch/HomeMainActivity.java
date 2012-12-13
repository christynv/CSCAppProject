package com.example.mixnmatch;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mixnmatch.Man_frag;
import com.example.mixnmatch.WomanFragment;


public class HomeMainActivity extends FragmentActivity {

	private PageAdapter pagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_main);
		initializePaging();
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayShowTitleEnabled(true);
	    actionBar.setDisplayShowHomeEnabled(true);
	    this.setRequestedOrientation(
	    		ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		  
	}
	private void initializePaging()
	{
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Man_frag.class.getName()));
		fragments.add(Fragment.instantiate(this, WomanFragment.class.getName()));
		this.pagerAdapter = new PageAdapter(super.getSupportFragmentManager(),fragments);
		
		ViewPager pager = (ViewPager)super.findViewById(R.id.homepager);
		pager.setAdapter(this.pagerAdapter);
		
	}}
	