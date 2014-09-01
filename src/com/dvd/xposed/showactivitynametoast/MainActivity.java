package com.dvd.xposed.showactivitynametoast;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.pref);
		getPreferenceManager().setSharedPreferencesName("pref");
		getPreferenceManager().setSharedPreferencesMode(
				Context.MODE_WORLD_READABLE);
	}
}
