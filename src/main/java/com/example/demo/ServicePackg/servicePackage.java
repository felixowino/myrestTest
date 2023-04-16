package com.example.demo.ServicePackg;

import java.util.List;

import com.example.demo.DAOPackage.DaoClass;

public interface servicePackage {

void saveKilifiTworecord(DaoClass dao);

List<DaoClass> getalldata();

List<DaoClass> getformdata(String nameinput);

void deletemyrecord(int myid);

DaoClass saveupdate(int id, String myartist, String mylyrics, String sname, String mydialect, String describe,
		String youtube, String result);

}
