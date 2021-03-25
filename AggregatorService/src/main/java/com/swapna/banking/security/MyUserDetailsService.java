package com.swapna.banking.security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		HashMap<String,String> map=new HashMap<String,String>();
		map.put("imran", "imran");
		map.put("vilas", "vilas");
		map.put("swapna", "swapna");
		map.put("sagar", "sagar");
		map.put("nagendra", "nagendra");
		map.put("noor", "noor");
		//String username = null;
		String password = map.get(s);
		return new User(s, password, new ArrayList<>());
	}

}