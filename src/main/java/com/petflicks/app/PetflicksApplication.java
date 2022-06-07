package com.petflicks.app;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.petflicks.app.Api.S3ApiUtil;

@SpringBootApplication
public class PetflicksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetflicksApplication.class, args);
		
		
		
//File file = new File("C:/hello.txt");
//		S3ApiUtil.upload(file);
	
	
	}

}
