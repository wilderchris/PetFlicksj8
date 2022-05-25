package com.petflicks.app.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.petflicks.app.Exception.InvalidLoginException;
import com.petflicks.app.Exception.UserNotFoundException;
import com.petflicks.app.Exception.UsernameAlreadyExists;
import com.petflicks.app.Models.User;
import com.petflicks.app.Repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
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
	@Transactional(propagation=Propagation.SUPPORTS)
	public User register(User newUser) throws UsernameAlreadyExists {//
		try
		{
				newUser = ((CrudRepository<User, Integer>) userRepo).save(newUser);
				return newUser;
		}catch (Exception e) {
			throw new UsernameAlreadyExists();
		}
		
	}

	@Override
	@Transactional
	public User getUserById(int userId) throws UserNotFoundException {/// working
		return userRepo.findById(userId).get();
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {//working
		return userRepo.findByEmail(email);
		
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {//
		User user = userRepo.findByUsername(username.toLowerCase().replace(" ", ""));
		return user;
	}

	@Override
	public User update(User user) throws UserNotFoundException {//
		if (userRepo.existsById(user.getUserId())) {
			userRepo.save(user);
			user = userRepo.findById(user.getUserId()).get();
			return user;
		}
		return null;
	}

	@Override
	public User deleteUser(User user) throws UserNotFoundException {//
		User userFromDatabase = userRepo.findById(user.getUserId()).get();
		if(userFromDatabase != null) {
			userRepo.delete(userFromDatabase);
		}
		return userFromDatabase;
	}

}
