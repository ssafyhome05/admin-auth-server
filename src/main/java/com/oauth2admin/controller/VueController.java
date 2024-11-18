package com.oauth2admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueController {

	@GetMapping("/login")
	public String login() {
		return "/index.html";
	}

	@GetMapping("/signup")
	public String signup() {
		return "/index.html";
	}

	@GetMapping("/oauth2/consent")
	public String consent() {
		return "/index.html";
	}
}
