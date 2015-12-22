package com.example.studio.android.bo.testmoi.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.studio.android.bo.testmoi.R;
import com.example.studio.android.bo.testmoi.adapter.AlreadySearchLocationAdapter;

public class SearchLocation extends AppCompatActivity {
    private RecyclerView mAlreadySearchRecclerView;
    private AlreadySearchLocationAdapter mAlreadySearchLocationAdapter;
    private ImageView imgPrvious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);

        init();
        listener();
//        checkNearbyLocation();

//        mAlreadySearchRecclerView = (RecyclerView) findViewById(R.id.card_location_already_search);
//        mAlreadySearchRecclerView.setHasFixedSize(true);
//        mAlreadySearchRecclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        mAlreadySearchLocationAdapter = new AlreadySearchLocationAdapter(getApplicationContext(),);
//        mAlreadySearchRecclerView.setAdapter(mAlreadySearchLocationAdapter);


    }
    public void init(){
        imgPrvious = (ImageView) findViewById(R.id.imgprevious);


    }
    public void listener(){
        imgPrvious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("bug","imgprevious clicked");
                onBackPressed();
            }
        });
    }
    public void checkNearbyLocation(){

    }

}
