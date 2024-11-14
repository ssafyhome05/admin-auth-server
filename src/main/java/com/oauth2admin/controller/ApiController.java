package com.oauth2admin.controller;

import com.oauth2admin.entity.AdminEntity;
import com.oauth2admin.service.AdminService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final AdminService adminService;

	public ApiController(AdminService adminService) {

		this.adminService = adminService;
	}

	@GetMapping("/user-info")
	public UserDetails getUserDetails() {

		return adminService.getUserInfo();
	}

	@PostMapping("/signup")
	public void signup(@RequestBody AdminEntity adminEntity) {

		adminService.signup(adminEntity);
	}
}
