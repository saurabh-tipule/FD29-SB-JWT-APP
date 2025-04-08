package com.cjc.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoDetails implements UserDetails {

	private String username; // Changed from 'name' to 'email' for clarity
	private String password;
	private List<GrantedAuthority> authorities;

	public UserInfoDetails(UserInfo userInfo) {

		this.username = userInfo.getEmail(); // Use email as username
		this.password = userInfo.getPassword();

		GrantedAuthority ga = new SimpleGrantedAuthority(userInfo.getRoles());

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(ga);

		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

}
