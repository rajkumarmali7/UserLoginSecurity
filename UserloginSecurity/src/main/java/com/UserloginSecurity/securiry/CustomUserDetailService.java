package com.UserloginSecurity.securiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.UserloginSecurity.Configration.ResourceNotFoundException;
import com.UserloginSecurity.dao.UserRepository;
import com.UserloginSecurity.entity.User;

@Service
public class CustomUserDetailService implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//** loading user from database by username */
		User user = this.userRepository.findByEmailId(username).orElseThrow(()->new ResourceNotFoundException("User " , "emailId :"+username,0));
		
		
		return user;
	}

}
