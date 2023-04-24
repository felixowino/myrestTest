package com.example.demo.modelPackage;

public class UsersModel {
	
	
	private int  MemberID;
	private String Uname;
	private String Fname;
	private String Sname;
	private String Pwrd;
	private String Email;
	private String auth;
	private int ena;
	
	
	
	
	@Override
	public String toString() {
		return "UsersModel [MemberID=" + MemberID + ", Uname=" + Uname + ", Fname=" + Fname + ", Sname=" + Sname
				+ ", Pwrd=" + Pwrd + ", Email=" + Email + ", auth=" + auth + ", ena=" + ena + "]";
	}
	
	
	public String getUname() {
		return Uname;
	}


	public void setUname(String uname) {
		Uname = uname;
	}


	public int getMemberID() {
		return MemberID;
	}
	public void setMemberID(int memberID) {
		MemberID = memberID;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getPwrd() {
		return Pwrd;
	}
	public void setPwrd(String pwrd) {
		Pwrd = pwrd;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getEna() {
		return ena;
	}
	public void setEna(int ena) {
		this.ena = ena;
	}
	

	
	
	
}
