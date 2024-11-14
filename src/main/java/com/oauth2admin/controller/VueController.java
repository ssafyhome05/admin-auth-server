package com.oauth2admin.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueController implements ErrorController {

	@GetMapping("/error")
	public String error() {
		return "/index.html";
	}
}
