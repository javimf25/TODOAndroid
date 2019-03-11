package org.udg.pds.todoandroid.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import org.udg.pds.todoandroid.R;
import org.udg.pds.todoandroid.entity.Domicili;

import java.util.ArrayList;
import java.util.List;

public class AdapterLListarDomicilis extends RecyclerView.Adapter<AdapterLListarDomicilis.MyViewHolder> {
    private final Context context;
    private List<Domicili>  mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView direccio,provincia,poblacio,metresquadrats,nhab;
        public Button claus,neteja;
        public MyViewHolder(View itemView) {
            super(itemView);
            direccio=itemView.findViewById(R.id.carrer);
            provincia=itemView.findViewById(R.id.provincia);
            poblacio=itemView.findViewById(R.id.poblacio);
            metresquadrats=itemView.findViewById(R.id.metres);
            nhab=itemView.findViewById(R.id.numerohabs);
            claus=itemView.findViewById(R.id.claus);
            neteja=itemView.findViewById(R.id.neteja);
        }
    }

    public void setData(List<Domicili> dom){

        mDataset=dom;
        notifyDataSetChanged();

    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterLListarDomicilis(Context context) {
        this.context = context;
        this.mDataset=new ArrayList<Domicili>();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterLListarDomicilis.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.domicilifitxa, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.direccio.setText(mDataset.get(position).getDireccio());
        holder.poblacio.setText(mDataset.get(position).getPoblacio());
        holder.provincia.setText(mDataset.get(position).getProvincia());
        holder.nhab.setText(String.valueOf(mDataset.get(position).getnHabitacions()));
        holder.metresquadrats.setText(String.valueOf(mDataset.get(position).getm2()));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();

    }
}