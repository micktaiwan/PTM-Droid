package com.micktaiwan.ptmdroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends Activity {

	private Credentials credentials;
	private EditText 	edit_login;
	private EditText 	edit_pwd;
	private Button 		save_button;
	private Config 		config;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		credentials 	= new Credentials();
		config 			= new Config();
		config.load(getApplicationContext(), credentials);
		edit_login 		= (EditText) findViewById(R.id.login);
		edit_pwd 		= (EditText) findViewById(R.id.pwd);
		edit_login.setText(credentials.login.toString());
		edit_pwd.setText(credentials.pwd.toString());
		save_button 	= (Button) findViewById(R.id.save);
		save_button.setOnClickListener(mSaveListener);
	}

	OnClickListener mSaveListener = new OnClickListener() {
		public void onClick(View v) {
			credentials.set(edit_login.getText().toString(), edit_pwd.getText()
					.toString());
			config.save(getApplicationContext(), credentials);
			setResult(RESULT_OK);
			finish();
		}
	};
	/*
	 * @Override protected void onPause() { super.onPause(); }
	 */
}
