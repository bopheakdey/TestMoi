package com.example.studio.android.bo.testmoi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studio.android.bo.testmoi.R;

/**
 * Created by User on 12/22/2015.
 */
public class WishHouseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wish_house_layout, container, false);

        return rootView;
    }
}
