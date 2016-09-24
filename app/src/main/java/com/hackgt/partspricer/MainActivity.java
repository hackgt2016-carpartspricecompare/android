package com.hackgt.partspricer;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import static com.hackgt.partspricer.R.id.bottomBar;

public class MainActivity extends AppCompatActivity implements PartsFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.app.Fragment partsFragment = new com.hackgt.partspricer.PartsFragment();
//        FrameLayout fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);



        getFragmentManager().beginTransaction().add(R.id.fragment_container, partsFragment).commit();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
