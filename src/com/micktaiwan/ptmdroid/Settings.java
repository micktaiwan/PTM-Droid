package com.micktaiwan.ptmdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Settings extends Activity {

	private Credentials credentials;
	private EditText edit_login;
	private EditText edit_pwd;
	private Config config;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		credentials = new Credentials();
		config = new Config();
		config.load(getApplicationContext(), credentials);
 		edit_login = (EditText)findViewById(R.id.login);
		edit_pwd   = (EditText)findViewById(R.id.pwd);
		edit_login.setText(credentials.login.toString());
		edit_pwd.setText(credentials.pwd.toString());
	}

	@Override
	protected void onPause() {
		super.onPause();
		credentials.set(edit_login.getText().toString(), edit_pwd.getText().toString());
		config.save(getApplicationContext(), credentials);
		setResult(RESULT_OK);
	}
}
