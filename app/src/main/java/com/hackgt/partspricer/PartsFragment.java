package com.hackgt.partspricer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PartsFragment extends android.app.Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView                  partCategoryRV;

    public PartsFragment() {
        // Required empty public constructor
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView categoryTitle;
        private       Category category;

        public CategoryViewHolder (View itemView) {
            super(itemView);

            categoryTitle = (TextView) itemView.findViewById(R.id.part_category_title);
            itemView.setOnClickListener(this);
        }

        public void setCategory (Category category) {
            this.category = category;

            categoryTitle.setText(category.getName());
        }

        @Override
        public void onClick (View v) {
            Intent intent = new Intent(v.getContext(), CategoryDetailActivity.class);
            intent.putExtra("category", category);
            startActivity(intent);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parts, container, false);

        partCategoryRV = (RecyclerView) view.findViewById(R.id.part_category_RV);
        partCategoryRV.setLayoutManager(new LinearLayoutManager(partCategoryRV.getContext()));
        partCategoryRV.setAdapter(new RecyclerView.Adapter<CategoryViewHolder>() {
            @Override
            public CategoryViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parts_category_card, parent, false);
                return new CategoryViewHolder(view);
            }

            @Override
            public void onBindViewHolder (CategoryViewHolder holder, int position) {
                holder.setCategory(DataStore.getPartCategories().get(position));
            }

            @Override
            public int getItemCount () {
                return DataStore.getPartCategories().size();
            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
