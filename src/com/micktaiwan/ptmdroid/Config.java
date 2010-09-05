package com.micktaiwan.ptmdroid;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;

public class Config {

	final static String FILENAME = "config.txt";

	public void load(Context ctx, Credentials c) {
		FileInputStream fis;
		BufferedReader br;
		try {
			fis = ctx.openFileInput(FILENAME);
			br = new BufferedReader(new InputStreamReader(fis));
			c.set(br.readLine(), br.readLine());
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save(Context ctx, Credentials c) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			String string = c.login + "\n" + c.pwd + "\n";
			fos.write(string.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}