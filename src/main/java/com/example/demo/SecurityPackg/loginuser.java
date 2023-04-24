package com.example.demo.SecurityPackg;

public class loginuser {
	private String pass;
	private String user;
	
	
	
	@Override
	public String toString() {
		return "loginuser [pass=" + pass + ", user=" + user + "]";
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	

}
