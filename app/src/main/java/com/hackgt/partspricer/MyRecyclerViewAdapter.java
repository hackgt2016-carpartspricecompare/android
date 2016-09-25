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

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Car> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView vin;
        TextView make;
        TextView model;
        TextView year;
        TextView manufacturer;
        TextView onstartStatus;


        public DataObjectHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
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
        Car car = mDataset.get(position);

        holder.title.setText(car.getMake() + " " + car.getModel());
        holder.vin.setText("VIN: " + car.getVin());
        holder.make.setText("Make: " + car.getMake());
        holder.model.setText("Model: " + car.getModel());
        holder.year.setText("Year: " + String.valueOf(car.getYear()));
        holder.manufacturer.setText("Manufacturer: " + car.getManufacturer());
        holder.onstartStatus.setText("OnStar: " + car.getOnstarStatus());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}