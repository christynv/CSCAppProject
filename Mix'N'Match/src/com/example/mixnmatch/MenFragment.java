package com.example.mixnmatch;

import com.example.mixnmatch.HomeMainActivity;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenFragment extends Fragment {

	ViewPager mViewPager;
	ViewPager mViewPager1;
	PageAdapter mAdapter;
	PageAdapter mAdapter1;
	View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		mView = inflater.inflate(R.layout.men_frag_layout, container, false);
		mViewPager = (ViewPager)mView.findViewById(R.id.mentoppager);
		mAdapter = new PageAdapter();
		mViewPager.setAdapter(mAdapter);
		
		mViewPager1 = (ViewPager)mView.findViewById(R.id.menbottompager);
		mAdapter1 = new PageAdapter();
		mViewPager.setAdapter(mAdapter1);
		
		
		return mView;

	}
	public class PageAdapter extends PagerAdapter
	{
		@Override
		public Object instantiateItem(ViewGroup a, int b)
		{
	      /* TextView view = new TextView(getActivity());
	        view.setText("Item " + b);
	        view.setGravity(Gravity.CENTER);
	        view.setBackgroundColor(Color.argb(255, b * 50,
	                b * 10, b * 50));*/
			switch (b)
			{
			case 0:
				 a.setBackgroundResource(R.drawable.ic_action_photo);
			case 1:
				 a.setBackgroundResource(R.drawable.ic_launcher);
			}
			
	     
	       // a.addView(view);
	        return a;
			
		}
		@Override
		public void destroyItem(ViewGroup a, int b, Object c)
		{
			a.removeView((View) c);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return (arg0 == arg1);
		}
		
	}
}


