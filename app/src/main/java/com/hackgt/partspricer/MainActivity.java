package com.hackgt.partspricer;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements PartsFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        android.app.Fragment partsFragment = new com.hackgt.partspricer.PartsFragment();
//        FrameLayout fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);

//        getFragmentManager().beginTransaction().add(R.id.fragment_container, partsFragment).commit();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment;
                if (tabId == R.id.tab_parts) { fragment = new PartsFragment(); }
                else { fragment = new Fragment(); }

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
