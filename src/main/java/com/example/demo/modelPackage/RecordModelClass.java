package com.example.demo.modelPackage;

public class RecordModelClass{
	
	private String Lyrics;
	private String Artist;
	private String Youtube;
    private String photo;
    private String Desc;
    private String Name;
    private String Dialct; 
	@Override
	public String toString() {
		return "RecordModelPackg [Lyrics=" + Lyrics + ", Artist=" + Artist + ", Youtube=" + Youtube + ", photo=" + photo
				+ ", Desc=" + Desc + ", Name=" + Name + ", Dialct=" + Dialct + "]";
	}
	public String getLyrics() {
		return Lyrics;
	}
	public void setLyrics(String lyrics) {
		Lyrics = lyrics;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getYoutube() {
		return Youtube;
	}
	public void setYoutube(String youtube) {
		Youtube = youtube;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDialct() {
		return Dialct;
	}
	public void setDialct(String dialct) {
		Dialct = dialct;
	}
}
