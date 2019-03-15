package org.udg.pds.todoandroid.util;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import org.udg.pds.todoandroid.R;
import org.udg.pds.todoandroid.entity.Domicili;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

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

            this.neteja.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // inflate the layout of the popup window
                    LayoutInflater inflater = LayoutInflater.from(context);
                    View popupView = inflater.inflate(R.layout.popupneteja, null);

                    // create the popup window
                    int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    boolean focusable = true; // lets taps outside the popup also dismiss it
                    final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                    // show the popup window
                    // which view you pass in doesn't matter, it is only used for the window tolken
                    popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

                    // dismiss the popup window when touched
                    popupView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            return true;
                        }
                    });
                }
            });
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