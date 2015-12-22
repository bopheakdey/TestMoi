package com.example.studio.android.bo.testmoi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studio.android.bo.testmoi.R;
import com.example.studio.android.bo.testmoi.model.ContactInfo;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.studio.android.bo.testmoi.R.drawable.a;

/**
 * Created by User on 12/18/2015.
 */
 public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder>{


    private List<ContactInfo> contactList;
    private Context context;

    public  RecyclerViewAdapter(Context context, List<ContactInfo>contactList){
        this.contactList = contactList;
        this.context = context;
    }



    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        ContactInfo contactInfo = contactList.get(position);
        if(position==0){
            Picasso.with(context).load(R.drawable.a).centerCrop().fit().into(holder.mImg);
        }else if (position == 1){
            Picasso.with(context).load(R.drawable.b).centerCrop().fit().into(holder.mImg);
        }else if (position == 2){
            Picasso.with(context).load(R.drawable.c).centerCrop().fit().into(holder.mImg);
        }else if (position == 3){
            Picasso.with(context).load(R.drawable.d).centerCrop().fit().into(holder.mImg);
        }else if (position == 4){
            Picasso.with(context).load(R.drawable.e).centerCrop().fit().into(holder.mImg);
        }else if (position == 5){
            Picasso.with(context).load(R.drawable.f).centerCrop().fit().into(holder.mImg);
        }else if (position == 6){
            Picasso.with(context).load(R.drawable.g).centerCrop().fit().into(holder.mImg);
        }else {
            Picasso.with(context).load(R.drawable.central_market_night).fit().into(holder.mImg);
//        holder.mImg.setImageResource(R.drawable.a);
//        Picasso.with(context).load(R.drawable.a).centerCrop().fit().into(holder.mImg);
        }

        holder.tName.setText(contactInfo.name);
        holder.tSurname.setText(contactInfo.surname);
        holder.tEmail.setText(contactInfo.email);
        holder.tTitle.setText(contactInfo.name + " "+ contactInfo.surname);

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        protected TextView tName, tEmail, tSurname, tTitle;
        protected ImageView mImg;


        public ContactViewHolder(View itemView) {
            super(itemView);
            tName = (TextView) itemView.findViewById(R.id.txtName);
            tSurname = (TextView) itemView.findViewById(R.id.txtSurname);
            tEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            tTitle = (TextView) itemView.findViewById(R.id.title);
            mImg = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
