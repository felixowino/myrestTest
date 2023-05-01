package com.example.demo.ServicePackg;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.RepoPackg.Urepo;
import com.example.demo.entitypackage.MembersEntity;

@Service
public class myUsersConfigClass implements UserDetailsService {
	@Autowired
	private Urepo  mymbrs;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MembersEntity dbuser=mymbrs.findByUsername(username);
		if(dbuser == null){
	        throw new UsernameNotFoundException("Utente non trovato");
	    }
		int enabled = dbuser.getEnabled();
		if(enabled != 0) {
		ArrayList<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority myauth = new SimpleGrantedAuthority(dbuser.getAuthorities().toUpperCase());
		authority.add(myauth);
		
		return new  User(dbuser.getUsername(), dbuser.getPassword(), authority);
		}
		return null;
		
	}
	

}
