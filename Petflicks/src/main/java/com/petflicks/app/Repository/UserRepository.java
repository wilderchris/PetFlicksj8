package com.petflicks.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petflicks.app.Models.User;

public class UserRepository {
      
	
	@Repository
	public interface UserDAO extends JpaRepository <User, Integer>{
		
		public User findByEmail(String email);
		public User findByUsername(String username);
	
}
}
