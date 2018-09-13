package com.android.ephesushealing.epheal.Activity.Adapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.ephesushealing.epheal.Activity.Model.IlacList;
import com.android.ephesushealing.epheal.R;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by noavaran on 9/27/2016.
 */
public class IlacAdapter extends RecyclerView.Adapter<IlacAdapter.mybookingViewHolder> {


    Context context;
    Fragment fragment;
    FragmentManager fm;
    FragmentTransaction ft;
    View v;
    String delete = "false";
    ArrayList<IlacList> unPayedReserveMOdels;
    String pay = "false";


    public IlacAdapter(ArrayList<IlacList> unPayedReserveMOdels) {
        this.unPayedReserveMOdels = unPayedReserveMOdels;


    }

    @Override
    public mybookingViewHolder onCreateViewHolder(final ViewGroup parent, final int position) {

            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recetelist, parent, false);

        mybookingViewHolder pvh = new mybookingViewHolder(v);
        context = parent.getContext();


        return pvh;

    }

    @Override
    public void onBindViewHolder(mybookingViewHolder holder, final int position) {

        holder.itemView.setTag(unPayedReserveMOdels.get(position));



    }


    @Override
    public int getItemCount() {
        return unPayedReserveMOdels.size();
    }


    public static class mybookingViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        Button btndelete, btnpay;
        Fragment fragment;
        FragmentManager fm;
        FragmentTransaction ft;
        Integer z;



        mybookingViewHolder(final View itemView) {
            super(itemView);


        }
    }

}
