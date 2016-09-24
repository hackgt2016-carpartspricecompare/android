package com.hackgt.partspricer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import static com.hackgt.partspricer.R.id.bottomBar;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		com.hackgt.partspricer.PartsFragment partsFragment = new com.hackgt.partspricer.PartsFragment();
		FrameLayout fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);

		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().add(R.id.fragment_container, partsFragment).commit();

		BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
		bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
			@Override
			public void onTabSelected (@IdRes int tabId) {

			}
		});
	}
}
