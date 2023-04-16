package com.example.demo.DAOPackage;

public class DaoClass {
	
	private String songLyrics;
	private String songArtist;
	private String Youtubelnk;
    private String passpotphoto;
    private String songDesc;
    private String songName;
    private String songDialct;
	


	public String getSongLyrics() {
		return songLyrics;
	}
	public void setSongLyrics(String songLyrics) {
		this.songLyrics = songLyrics;
	}
	public String getSongArtist() {
		return songArtist;
	}
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	public String getYoutubelnk() {
		return Youtubelnk;
	}
	public void setYoutubelnk(String youtubelnk) {
		Youtubelnk = youtubelnk;
	}
	public String getPasspotphoto() {
		return passpotphoto;
	}
	public void setPasspotphoto(String passpotphoto) {
		this.passpotphoto = passpotphoto;
	}
	public String getSongDesc() {
		return songDesc;
	}
	public void setSongDesc(String songDesc) {
		this.songDesc = songDesc;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongDialct() {
		return songDialct;
	}
	public void setSongDialct(String songDialct) {
		this.songDialct = songDialct;
	}
	@Override
	public String toString() {
		return "DaoClass [songLyrics=" + songLyrics + ", songArtist=" + songArtist + ", Youtubelnk=" + Youtubelnk
				+ ", passpotphoto=" + passpotphoto + ", songDesc=" + songDesc + ", songName=" + songName
				+ ", songDialct=" + songDialct + "]";
	}
    

	
}
