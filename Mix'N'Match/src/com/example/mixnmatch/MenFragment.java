package com.example.mixnmatch;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		if(container == null)
		{
			return null;
		}
		return inflater.inflate(R.layout.men_frag_layout, container, false);
	}
}
