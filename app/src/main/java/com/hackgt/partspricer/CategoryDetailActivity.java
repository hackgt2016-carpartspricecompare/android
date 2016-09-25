package com.hackgt.partspricer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CategoryDetailActivity extends AppCompatActivity {
    private class CategoryDetailAdapter extends RecyclerView.Adapter {
        private Category category;

        public CategoryDetailAdapter (Category category) {
            this.category = category;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
            TextView tv = new TextView(parent.getContext());
            tv.setPadding(30, 30, 30, 30);
            return new RecyclerView.ViewHolder(tv) { };
        }

        @Override
        public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
            final Part part = category.getParts().get(position);
            ((TextView) holder.itemView).setText(part.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    Intent intent = new Intent(v.getContext(), PartDetailActivity.class);
                    intent.putExtra("part", part);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount () {
            return category.getParts().size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Category category = getIntent().getParcelableExtra("category");
        setTitle(category.getName());

        RecyclerView rv = (RecyclerView) findViewById(R.id.categoryListing);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CategoryDetailAdapter(category));
    }
}
