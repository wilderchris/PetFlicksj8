package com.petflicks.app.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petflicks.app.Exception.InvalidLoginException;
import com.petflicks.app.Exception.UserNotFoundException;
import com.petflicks.app.Exception.UsernameAlreadyExists;
import com.petflicks.app.Models.User;
import com.petflicks.app.Repository.UserRepository.UserRepo;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	private UserRepo userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	
	@Override
	public User login(String username, String password) throws UserNotFoundException, InvalidLoginException {

		User userFromDatabase = userRepo.findByUsername(username);
		if (userFromDatabase != null && userFromDatabase.getPassword().equals(password)) 
		{
			return userFromDatabase;
		} else if (userFromDatabase == null ) {
			throw new UserNotFoundException();	
		} else {
			throw new InvalidLoginException();
		}
	}

	@Override
	public User register(User newUser) throws UsernameAlreadyExists {
		try
		{
				newUser = userRepo.save(newUser);
				return newUser;
		}catch (Exception e) {
			throw new UsernameAlreadyExists();
		}
		
	}

	@Override
	@Transactional
	public User getUserById(int userId) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) return user.get();
		else return null;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		User user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {
		User user = userRepo.findByUsername(username.toLowerCase().replace(" ", ""));
		return user;
	}

	@Override
	public User update(User user) throws UserNotFoundException {
		if (userRepo.existsById(user.getUserId())) {
			userRepo.save(user);
			user = userRepo.findById(user.getUserId()).get();
			return user;
		}
		return null;
	}

	@Override
	public User deleteUser(User user) throws UserNotFoundException {
		User userFromDatabase = userRepo.findById(user.getUserId()).get();
		if(userFromDatabase != null) {
			userRepo.delete(userFromDatabase);
		}
		return userFromDatabase;
	}

}
