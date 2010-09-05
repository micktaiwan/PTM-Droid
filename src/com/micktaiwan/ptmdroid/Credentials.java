package com.micktaiwan.ptmdroid;

public class Credentials  {
	public String login;
	public String pwd;
	
	void set(String l, String p) {
		login 	= (l==null ? "" : l);
		pwd 	= (p==null ? "" : p);
	}
}
