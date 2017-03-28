package com.iducate.preferencefragmentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//read the values at app startup so we can show this in the UI
		boolean male = MyPreferenceFragment.isMale(this);
		String name = MyPreferenceFragment.getName(this);
		updateUI(name,male);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//This method updates our text views.
	public void updateUI(String name, boolean male)
	{
		TextView myName = (TextView) findViewById(R.id.myName);
		TextView myGender = (TextView) findViewById(R.id.myGender);
		myName.setText(name);
		if (male)
			myGender.setText("Male");
		else
			myGender.setText("Female");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==1) //the code means we came back from settings
		{
			//I can can these methods like this, because they are static
			boolean male = MyPreferenceFragment.isMale(this);
			String name = MyPreferenceFragment.getName(this);
			String message = "Welcome, "+name+", You are male? "+male;
			Toast toast = Toast.makeText(this,message,Toast.LENGTH_LONG);
			toast.show();
			updateUI(name,male);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId()==R.id.action_settings)
		{
			//Start our settingsactivity and listen to result - i.e.
			//when it is finished.
			Intent intent = new Intent(this,SettingsActivity.class);
			startActivityForResult(intent,1);
			//notice the 1 here - this is the code we then listen for in the
			//onActivityResult

		}
		return super.onOptionsItemSelected(item);
	}
}
