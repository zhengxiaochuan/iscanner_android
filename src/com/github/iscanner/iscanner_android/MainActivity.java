package com.github.iscanner.iscanner_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	private String TAG = "iscanner";
	private Button leftButton;
	private Button rightButton;
	private TextView copyright;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		rightButton = (Button) findViewById(R.id.button_second);
		rightButton.setVisibility(View.VISIBLE);
		leftButton = (Button) findViewById(R.id.button_first);
		copyright = (TextView) findViewById(R.id.copyright);
		leftButton.setOnClickListener(this);
		rightButton.setOnClickListener(this);
		copyright.setOnClickListener(this);
		Log.i(TAG, "start loading...");
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_first:
			break;
		case R.id.button_second:
			Intent intentHistory = new Intent(this, HistoryActivity.class);
			startActivity(intentHistory);
			break;
		case R.id.copyright:
			Intent intentAbout = new Intent(this, AboutActivity.class);
			startActivity(intentAbout);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
