package com.iducate.preferencefragmentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==1) //from settings
		{
			boolean male = MyPreferenceFragment.isMale(this);
			String name = MyPreferenceFragment.getName(this);
			String message = "Welcome, "+name+", You are male? "+male;
			Toast toast = Toast.makeText(this,message,Toast.LENGTH_LONG);
			toast.show();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId()==R.id.action_settings)
		{
			//Start our settingsactivity and liste to result
			Intent intent = new Intent(this,SettingsActivity.class);
			startActivityForResult(intent,1);

		}
		return super.onOptionsItemSelected(item);
	}
}
