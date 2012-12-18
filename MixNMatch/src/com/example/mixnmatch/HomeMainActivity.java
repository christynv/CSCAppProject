/*****Richard Luu & Christyn Vasquez****/
/* Home Page Activity Containing Two Fragment Classes */

package com.example.mixnmatch;

import java.util.List;
import java.util.Vector;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;


public class HomeMainActivity extends FragmentActivity {

	private PageAdapter pagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_home_main);
		initializePaging();
		this.setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
	}
	private void initializePaging()
	{
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Man_frag.class.getName()));
		fragments.add(Fragment.instantiate(this, WomanFragment.class.getName()));
		this.pagerAdapter = new PageAdapter(super.getSupportFragmentManager(),fragments);
		
		ViewPager pager = (ViewPager)super.findViewById(R.id.homepager);
	    PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip);
	    pagerTabStrip.setBackgroundColor(Color.BLACK);
	    pagerTabStrip.setTextColor(Color.WHITE);
		pager.setAdapter(this.pagerAdapter);
		
	}}
	