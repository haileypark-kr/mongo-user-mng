package com.example.mongousermng.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserWebController {

	@GetMapping("/signup")
	public String getSignupForm() {
		return "signup";
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}
}
