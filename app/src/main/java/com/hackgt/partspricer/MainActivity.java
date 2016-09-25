package com.hackgt.partspricer;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements PartsFragment.OnFragmentInteractionListener {
    public static class CarsFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            TextView textView = new TextView(container.getContext());
            textView.setText("fsafdasfasdf");
            return textView;
        }
    }

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
                int      inAnim;
                int      outAnim;
                if (tabId == R.id.tab_parts) {
                    fragment = new PartsFragment();
                    inAnim = android.R.animator.fade_in;
                    outAnim = android.R.animator.fade_out;
                }
                else {
                    fragment = new CarsFragment();
                    inAnim = android.R.animator.fade_in;
                    outAnim = android.R.animator.fade_out;
                }

                getFragmentManager().beginTransaction().setCustomAnimations(inAnim, outAnim).replace(R.id.fragment_container, fragment).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
