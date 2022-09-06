package com.example.mongousermng.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongousermng.dto.user.UserRoleUpdateDto;
import com.example.mongousermng.dto.user.UserSignupDto;
import com.example.mongousermng.service.user.UserDetailsServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/signup")
	public void signup(UserSignupDto signupDto) {

		userDetailsService.signup(signupDto);
	}

	@PostMapping("/user/role/update")
	public void changeUserRole(@RequestBody UserRoleUpdateDto userRoleUpdateDto) {

		userDetailsService.changeRole(userRoleUpdateDto);
	}

}
