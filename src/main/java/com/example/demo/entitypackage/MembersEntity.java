package com.example.demo.entitypackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myuserstable")
public class MembersEntity {
	@Id
	@Column(name="myusersid")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
   private int Id;
	@Column(name="UsesFname")
   private String FirstName;
	@Column(name="UsesSname")
   private String SecondName;
	@Column(name="Uname", unique = true)
	private String username;
	@Column(name="MyUsesEmail", unique = true)
	private String Email;
	@Column(name="MyUsespass" )
	private String Password;
	@Column(name="Authorities")
	private String Authorities;
	@Column(name="Status", columnDefinition = "int default 0")
	private int enabled;
	
	
	
	
	@Override
	public String toString() {
		return "MembersEntity [Id=" + Id + ", FirstName=" + FirstName + ", SecondName=" + SecondName + ", username="
				+ username + ", Email=" + Email + ", Password=" + Password + ", Authorities=" + Authorities
				+ ", enabled=" + enabled + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAuthorities() {
		return Authorities;
	}
	public void setAuthorities(String authorities) {
		Authorities = authorities;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
