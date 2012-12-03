package com.example.mixnmatch;

//import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
//import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

public class HomeMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(false);
	    actionBar.setDisplayShowHomeEnabled(false);
	    	    
	    Tab tab = actionBar.newTab().setText(R.string.tab1).setTabListener(new TabListener<MenFragment>(this,"men", MenFragment.class));
	    actionBar.addTab(tab);

	    tab = actionBar.newTab().setText(R.string.tab2).setTabListener(new TabListener<WomenFragment>(this,"women", WomenFragment.class));
	    actionBar.addTab(tab);
	    
	    tab = actionBar.newTab().setText(R.string.tab3).setTabListener(new TabListener<StyleFragment>(this,"style", StyleFragment.class));
	    actionBar.addTab(tab);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_layout, menu);
		return true;
		
	}
}
