package com.petflicks.app.Service;

import com.petflicks.app.Exception.InvalidLoginException;
import com.petflicks.app.Exception.UserNotFoundException;
import com.petflicks.app.Exception.UsernameAlreadyExists;
import com.petflicks.app.Models.User;

public class UserServiceImpl implements UserService{

	@Override
	public User login(String username, String password) throws UserNotFoundException, InvalidLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User register(User newUser) throws UsernameAlreadyExists {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
