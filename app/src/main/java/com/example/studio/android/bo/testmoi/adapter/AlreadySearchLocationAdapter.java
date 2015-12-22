package com.example.studio.android.bo.testmoi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studio.android.bo.testmoi.R;
import com.example.studio.android.bo.testmoi.model.ContactInfo;

import java.util.List;

/**
 * Created by User on 12/21/2015.
 */
public class AlreadySearchLocationAdapter extends RecyclerView.Adapter<AlreadySearchLocationAdapter.LocationViewHolder>{

    private Context context;


    public AlreadySearchLocationAdapter(Context context, List<ContactInfo> contactList) {
       this.context = context;

    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.card_location_already_search, parent, false);
        return new LocationViewHolder(item);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder{

        private TextView houseLocation, numberOfHouses;

        public LocationViewHolder(View v){
            super(v);
            houseLocation = (TextView)v.findViewById(R.id.location);
            numberOfHouses = (TextView) v.findViewById(R.id.number_of_houses);
        }
    }
}
