package com.petflicks.app.Petflicks.Service;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.petflicks.app.PetflicksApplication;
import com.petflicks.app.Models.User;
import com.petflicks.app.Repository.PetRepository;
import com.petflicks.app.Repository.UserRepository;
import com.petflicks.app.Service.UserService;

@SpringBootTest(classes=PetflicksApplication.class)
public class UserServiceTest {


	@MockBean
	private UserRepository userRepo;
	@MockBean
	private PetRepository petRepo;

	@Autowired
	private UserService userServ;

	private static Set<User> mockUsers;

	static String name;

	@BeforeAll
	public static void mockUsersSetup() {
		mockUsers = new HashSet<>();

		for (int i=1; i<=5; i++) {
			User user = new User();
			user.setUserId(i);
			name = String.valueOf(i);
			if (i<3)
				user.setFirstName("Test" + name);
			mockUsers.add(user);
		}
	}

	@Test
	public void registerUser() {
		
		
	}
	
	
}
