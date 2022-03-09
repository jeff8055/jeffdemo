package com.jfdmo.jfdmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfdmo.jfdmo.dto.UserDTO;
import com.jfdmo.jfdmo.entity.User;
import com.jfdmo.jfdmo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "welcome")
	public String welcome() {
		return "Welcome home";
	}
	
    @PostMapping(value = "saveUser")
    public UserDTO SaveUser(@RequestBody UserDTO userdto) {
    	UserDTO response = userService.saveUser(userdto);
    	return response;
    }

    @GetMapping(value = "getUserList")
    public List<User> getUserList(){
    	List<User> userList = userService.getUserList();
    	return userList;
    }
    
    @GetMapping(value = "getUserById")
    public UserDTO getUserById(@RequestParam Long id) {
    	UserDTO response = userService.getUserById(id);
    	return response;
    }
}
