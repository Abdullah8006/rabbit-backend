package com.rabbit.backend.controller;

import com.rabbit.backend.model.UserDto;
import com.rabbit.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping()
	public List<UserDto> getUsers(@RequestParam(required = false) Long id) {
		return userService.getForId(id);
	}

}
