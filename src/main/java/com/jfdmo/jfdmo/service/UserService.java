package com.jfdmo.jfdmo.service;

import java.util.List;

import com.jfdmo.jfdmo.dto.UserDTO;
import com.jfdmo.jfdmo.entity.User;

public interface UserService {
	
	UserDTO saveUser(UserDTO userDto);

	List<User> getUserList();

	UserDTO getUserById(Long id);

}
