package com.hackgt.partspricer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class PartDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Part part = (Part) getIntent().getSerializableExtra("part");
        setTitle(part.getName());

        TextView partPrice = (TextView) findViewById(R.id.partPrice);
        partPrice.setText(String.format("Part Price: %s", part.getPrice() == 0 ? "Unknown" : String.format("$%s", part.getPrice())));

        TextView partNumber = (TextView) findViewById(R.id.partNumber);
        partNumber.setText(String.format("Part Number: %s", part.getNumber()));

        TextView partCat = (TextView) findViewById(R.id.partCategory);
        partCat.setText(String.format("Part Category: %s", part.getCategory()));
    }
}
