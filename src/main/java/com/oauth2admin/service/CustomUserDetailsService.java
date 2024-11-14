package com.oauth2admin.service;

import com.oauth2admin.entity.AdminEntity;
import com.oauth2admin.mapper.AdminMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final AdminMapper adminMapper;

	public CustomUserDetailsService(AdminMapper adminMapper) {

		this.adminMapper = adminMapper;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AdminEntity entity = adminMapper.findAdminBySeq(username);

		return User.builder()
				.username(String.valueOf(entity.getAdminSeq()))
				.password(entity.getAdminPw())
				.roles(entity.getAdminRole())
				.build();
	}
}
