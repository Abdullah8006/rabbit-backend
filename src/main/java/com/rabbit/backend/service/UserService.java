package com.rabbit.backend.service;

import com.rabbit.backend.entity.User;
import com.rabbit.backend.model.UserDto;
import com.rabbit.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public List<UserDto> getForId(Long id) {
		List<User> users = null;

		if (id != null)
			users = userRepository.findById(id);
		else
			users = userRepository.findAll();

		return users.stream().map(user -> {
			UserDto dto = new UserDto();
			dto.setId(user.getId());
			dto.setName(user.getName());

			return dto;
		}).collect(Collectors.toList());
	}
}
