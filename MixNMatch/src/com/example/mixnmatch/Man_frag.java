package com.example.mixnmatch;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class Man_frag extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View mView = inflater.inflate(R.layout.man_frag_layout, container, false);
		
		Button button = (Button)mView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() 
       {
            public void onClick(View v) 
           {
          	 Intent intent = new Intent(getActivity(), ManActivity.class);
          	 getActivity().startActivity(intent);
         }
        });
        
		return mView;
				//(LinearLayout)inflater.inflate(R.layout.man_frag_layout, container, false);

	}
}
