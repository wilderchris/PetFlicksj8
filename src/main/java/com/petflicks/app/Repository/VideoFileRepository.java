package com.petflicks.app.Repository;

import io.github.cdimascio.dotenv.Dotenv;

public class VideoFileRepository {
	Dotenv dotenv = Dotenv.configure()
	        .directory("./src/main/resources")
	        .ignoreIfMalformed()
	        .ignoreIfMissing()
	        .load();
	

	
}
