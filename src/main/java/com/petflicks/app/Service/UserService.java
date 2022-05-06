package com.petflicks.app.Service;

import org.springframework.stereotype.Service;

import com.petflicks.app.Exception.InvalidLoginException;
import com.petflicks.app.Exception.UserNotFoundException;
import com.petflicks.app.Exception.UsernameAlreadyExists;
import com.petflicks.app.Models.User;

@Service
public interface UserService {

	public User login(String username, String password) throws UserNotFoundException, InvalidLoginException;
	public User register(User newUser) throws UsernameAlreadyExists;
	public User getUserById(int userId) throws UserNotFoundException;
	public User getUserByEmail(String email) throws UserNotFoundException;
	public User getUserByUsername(String username) throws UserNotFoundException;
	public User update(User user) throws UserNotFoundException;
	public User deleteUser(User user) throws UserNotFoundException;
	
	
	
}
