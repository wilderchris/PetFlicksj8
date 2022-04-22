package com.petflicks.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petflicks.app.Models.User;

public class UserRepository {
      
	
	@Repository
	public interface UserRepo extends JpaRepository <User, Integer>{
		
		public User findByEmail(String email);
		public User findByUsername(String username);
		public boolean existsById(long userId);
		public Optional<User> findById(long userId);
	
}
}
