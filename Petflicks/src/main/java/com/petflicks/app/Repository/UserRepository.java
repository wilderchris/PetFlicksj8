package com.petflicks.app.Repository;


import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petflicks.app.Models.User;


@Repository
@Table(name="usr")
public interface UserRepository extends JpaRepository <User, Integer>{
		
		public User findByEmail(String email);
		public User findByUsername(String username);
		public boolean existsById(int userId);
	
}
