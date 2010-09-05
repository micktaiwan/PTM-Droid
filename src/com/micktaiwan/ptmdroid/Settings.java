package com.micktaiwan.ptmdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Settings extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}

	@Override
	protected void onPause() {
		super.onPause();
		EditText l = (EditText) findViewById(R.id.login);
		EditText p = (EditText) findViewById(R.id.pwd);
		Credentials c = new Credentials();
		c.set(l.getText().toString(), p.getText().toString());
		Config config = new Config();
		config.save(getApplicationContext(), c);
		setResult(RESULT_OK);
	}
}
