package com.example.demo.entitypackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="lyricstable")
public class LyrcsEntity {
	@Id
	@Column(name="myid")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String myLyrics;
	
	private String myArtist;

	private String theYoutubelnk;
	@Lob
	private String mypasspotphoto;

	private String mysongDesc;

	private String mysongName;

	private String mysongDialct;

	@Override
	public String toString() {
		return "LyrcsEntity [myLyrics=" + myLyrics + ", myArtist=" + myArtist + ", theYoutubelnk=" + theYoutubelnk
				+ ", mypasspotphoto=" + mypasspotphoto + ", mysongDesc=" + mysongDesc + ", mysongName=" + mysongName
				+ ", mysongDialct=" + mysongDialct + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMyLyrics() {
		return myLyrics;
	}

	public void setMyLyrics(String myLyrics) {
		this.myLyrics = myLyrics;
	}

	public String getMyArtist() {
		return myArtist;
	}

	public void setMyArtist(String myArtist) {
		this.myArtist = myArtist;
	}

	public String getTheYoutubelnk() {
		return theYoutubelnk;
	}

	public void setTheYoutubelnk(String theYoutubelnk) {
		this.theYoutubelnk = theYoutubelnk;
	}

	public String getMypasspotphoto() {
		return mypasspotphoto;
	}

	public void setMypasspotphoto(String mypasspotphoto) {
		this.mypasspotphoto = mypasspotphoto;
	}

	public String getMysongDesc() {
		return mysongDesc;
	}

	public void setMysongDesc(String mysongDesc) {
		this.mysongDesc = mysongDesc;
	}

	public String getMysongName() {
		return mysongName;
	}

	public void setMysongName(String mysongName) {
		this.mysongName = mysongName;
	}

	public String getMysongDialct() {
		return mysongDialct;
	}

	public void setMysongDialct(String mysongDialct) {
		this.mysongDialct = mysongDialct;
	}

}
