/**RICHARD LUU & CHRISTYN VASQUEZ**/
/**FRAGMENT FOR WOMAN PAGE AT HOME SCREEN**/

package com.example.mixnmatch;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WomanFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View mView = inflater.inflate(R.layout.woman_frag_layout, container, false);
		mView.setBackgroundResource(R.drawable.home_screen2);
		Button button = (Button)mView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() 
       {
            public void onClick(View v) 
           {
          	 Intent intent = new Intent(getActivity(), WomanActivity.class);
          	 getActivity().startActivity(intent);
         }
        });
        
		return mView;

	}
}
