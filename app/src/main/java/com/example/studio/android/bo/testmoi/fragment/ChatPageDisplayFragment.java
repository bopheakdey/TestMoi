package com.example.studio.android.bo.testmoi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studio.android.bo.testmoi.MainActivity;
import com.example.studio.android.bo.testmoi.R;

/**
 * Created by User on 12/21/2015.
 */
public class ChatPageDisplayFragment extends Fragment {

    private TextView txtStartYourJourney;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.chat_page_layout, null, false);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        listener();



    }
    public void init(View v){
        txtStartYourJourney = (TextView) v.findViewById(R.id.start_your_journey);
    }
    public void listener(){
        txtStartYourJourney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager vp = ((MainActivity)getActivity()).getViewPager();
                vp.setCurrentItem(0,true);

            }
        });
    }
}
