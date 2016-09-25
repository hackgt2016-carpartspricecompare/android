package com.hackgt.partspricer;

/**
 * Created by Sri on 9/24/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Car> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView vin;
        TextView make;
        TextView model;
        TextView year;
        TextView manufacturer;
        TextView onstartStatus;


        public DataObjectHolder(View itemView) {
            super(itemView);
            vin = (TextView) itemView.findViewById(R.id.textView);
            make = (TextView) itemView.findViewById(R.id.textView2);
            model =(TextView) itemView.findViewById(R.id.textView3);
            year = (TextView) itemView.findViewById(R.id.textView4);
            manufacturer = (TextView) itemView.findViewById(R.id.textView5);
            onstartStatus = (TextView) itemView.findViewById(R.id.textView6);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<Car> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.vin.setText(mDataset.get(position).getVin());
        holder.make.setText(mDataset.get(position).getMake());
        holder.model.setText(mDataset.get(position).getModel());
        holder.year.setText(mDataset.get(position).getYear());
        holder.manufacturer.setText(mDataset.get(position).getManufacturer());
        holder.onstartStatus.setText(mDataset.get(position).getOnstartStatus());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}