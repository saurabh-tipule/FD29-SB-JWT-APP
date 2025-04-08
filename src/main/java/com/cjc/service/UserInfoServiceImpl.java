package com.cjc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cjc.entity.UserInfo;
import com.cjc.entity.UserInfoDetails;
import com.cjc.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService, UserDetailsService {

	@Autowired
	private UserInfoRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "User Added Successfully";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserInfo> userDetail = repository.findByEmail(username);

		// Converting UserInfo to UserDetails
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

	}

}
