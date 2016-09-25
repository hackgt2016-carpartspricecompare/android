package com.hackgt.partspricer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PartsFragment extends android.app.Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView                  partCategoryRV;

    public PartsFragment() {
        // Required empty public constructor
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryTitle;
        private final ListView partCategoryItemsLV;
        private       Category category;

        public CategoryViewHolder (View itemView) {
            super(itemView);

            categoryTitle = (TextView) itemView.findViewById(R.id.part_category_title);
            partCategoryItemsLV = (ListView) itemView.findViewById(R.id.part_category_items_LV);
        }

        public void setCategory (Category category) {
            this.category = category;

            categoryTitle.setText(category.getName());
            partCategoryItemsLV.setAdapter(new ArrayAdapter<>(partCategoryItemsLV.getContext(), android.R.layout.simple_list_item_1, category.getParts()));
            partCategoryItemsLV.invalidate();
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

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
