package com.example.demo.ServicePackg;

import java.util.List;

import com.example.demo.DAOPackage.DaoClass;
import com.example.demo.DAOPackage.UsersDao;
import com.example.demo.modelPackage.UsersModel;

public interface servicePackage {

void saveKilifiTworecord(DaoClass dao);

List<DaoClass> getalldata();

List<DaoClass> getformdata(String nameinput);

void deletemyrecord(int myid);

DaoClass saveupdate(int id, String myartist, String mylyrics, String sname, String mydialect, String describe,
		String youtube, String result);

void savemyuser(UsersDao udao);



}
