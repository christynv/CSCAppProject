/**RICHARD LUU & CHRISTYN VASQUEZ**/
/** PAGE ADAPTER FOR FRAGMENT MANAGMENT **/

package com.example.mixnmatch;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class PageAdapter extends FragmentPagerAdapter {
	
	private String titles[] = new String[]{"Man", "Woman"};
	
	private List<Fragment> fragments;
	public PageAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public CharSequence getPageTitle (int position){
		return titles[position];
	}
	

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.fragments.size();
	}
	

}
