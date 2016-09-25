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

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment;
                int      inAnim;
                int      outAnim;
                if (tabId == R.id.tab_parts) {
                    fragment = new PartsFragment();
                    inAnim = android.R.animator.fade_in;
                    outAnim = android.R.animator.fade_out;
                    setTitle("Part Categories");
                }
                else {
                    fragment = new CarFragment();
                    inAnim = android.R.animator.fade_in;
                    outAnim = android.R.animator.fade_out;
                    setTitle("Cars");
                }

                getFragmentManager().beginTransaction().setCustomAnimations(inAnim, outAnim).replace(R.id.fragment_container, fragment).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
