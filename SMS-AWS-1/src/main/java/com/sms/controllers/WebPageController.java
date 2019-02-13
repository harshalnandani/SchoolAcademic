package com.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {
	@GetMapping("/")
	public String index() {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/contactus")
	public String contactus() {
		return "/contactus";
	}

	@GetMapping("/requestademo")
	public String requestademo() {
		return "/requestademo";
	}
}
