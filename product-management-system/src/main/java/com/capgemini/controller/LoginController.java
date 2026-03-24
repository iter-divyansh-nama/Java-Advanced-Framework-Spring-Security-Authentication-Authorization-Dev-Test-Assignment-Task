package com.capgemini.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.entity.User;
import com.capgemini.model.security.JwtUtil;

@RestController
public class LoginController {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody User user) {

		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		return Map.of("token", jwtUtil.generateToken(user.getUsername()));
	}
}