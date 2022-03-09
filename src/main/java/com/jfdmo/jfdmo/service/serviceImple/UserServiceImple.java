package com.jfdmo.jfdmo.service.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfdmo.jfdmo.dto.UserDTO;
import com.jfdmo.jfdmo.entity.User;
import com.jfdmo.jfdmo.repository.UserRepository;
import com.jfdmo.jfdmo.service.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO saveUser(UserDTO userDto) {
		User user = new User();
		UserDTO response = new UserDTO();
		user.setName(userDto.getName());
		user.setMobileNo(userDto.getMobileNo());
		user.setUserName(userDto.getUserName());
	    User userSaveInDb =	userRepository.save(user);
	    
	    response.setId(userSaveInDb.getId());
	    response.setMobileNo(userSaveInDb.getMobileNo());
	    response.setName(userSaveInDb.getName());
	    response.setUserName(userSaveInDb.getUserName());
	    return response;
	}

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public UserDTO getUserById(Long id) {
		
		User user = userRepository.findByIdAndDeletedFalse(id);
		UserDTO response = new UserDTO();
		 response.setId(user.getId());
		    response.setMobileNo(user.getMobileNo());
		    response.setName(user.getName());
		    response.setUserName(user.getUserName());
		    return response;
		
	}

}
