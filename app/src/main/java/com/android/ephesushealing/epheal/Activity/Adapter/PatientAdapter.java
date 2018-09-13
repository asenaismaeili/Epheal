package com.android.ephesushealing.epheal.Activity.Adapter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.android.ephesushealing.epheal.Activity.Model.PatientCardModel;
import com.android.ephesushealing.epheal.Activity.MuayeneActivity;
import com.android.ephesushealing.epheal.Activity.Search_details;
import com.android.ephesushealing.epheal.R;


import java.util.List;

/**
 * Created by noavaran on 9/13/2016.
 */
public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.SelectViewHolder> {

    List<PatientCardModel> sellectItems;
    Context context;
    Integer pagenum;

    @Override
    public SelectViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_patient, parent, false);
        SelectViewHolder pvh = new SelectViewHolder(v);
        context = parent.getContext();

        return pvh;
    }

    @Override
    public void onBindViewHolder(final SelectViewHolder holder, final int position) {

        holder.btnfazla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pagenum==0){
                Intent myIntent = new Intent(context, Search_details.class);
                context.startActivity(myIntent);
                    }else {
                    Intent myIntent = new Intent(context, MuayeneActivity.class);
                    context.startActivity(myIntent);
                }

            }
        });


    }


    public PatientAdapter(List<PatientCardModel> sellectItems, Integer pagenum) {
        this.sellectItems = sellectItems;
        this.pagenum=pagenum;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class SelectViewHolder extends RecyclerView.ViewHolder {
        TextView btnfazla;


        SelectViewHolder(View itemView) {
            super(itemView);
            btnfazla = itemView.findViewById(R.id.btnfazla);


        }
    }

}