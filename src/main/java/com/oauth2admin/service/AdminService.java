package com.oauth2admin.service;

import com.oauth2admin.entity.AdminEntity;
import com.oauth2admin.mapper.AdminMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	private final AdminMapper adminMapper;
	private final BCryptPasswordEncoder passwordEncoder;

	public AdminService(AdminMapper adminMapper, BCryptPasswordEncoder passwordEncoder) {

		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void signup(AdminEntity adminEntity) {

		adminEntity.setAdminPw(passwordEncoder.encode(adminEntity.getAdminPw()));
		adminMapper.insertAdmin(adminEntity);
	}

	public UserDetails getUserInfo() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal() == null) {
			return null;
		}
		return (UserDetails) auth.getPrincipal();
	}
}
