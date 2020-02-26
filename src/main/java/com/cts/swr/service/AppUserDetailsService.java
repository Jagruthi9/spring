package com.cts.swr.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.swr.dao.AppUserEntityRepository;
import com.cts.swr.model.AppUserEntity;
import com.cts.swr.model.AppUserModel;



@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserEntityRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUserEntity user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), 
				user.getPassword(),
				new ArrayList<>());
	}
	
	public AppUserEntity save(AppUserModel userDTO) {
		AppUserEntity user = new AppUserEntity();
		user.setUserName(userDTO.getUserName());
		user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userDao.save(user);
	}

}