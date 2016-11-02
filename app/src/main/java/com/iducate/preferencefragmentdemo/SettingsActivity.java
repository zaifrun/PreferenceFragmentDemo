package com.iducate.preferencefragmentdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by makn on 02-11-2016.
 */

public class SettingsActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
       getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment())
                .commit();
    }
}
