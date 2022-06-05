package com.petflicks.app.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;

import io.github.cdimascio.dotenv.Dotenv;

public class VideoFileRepository {
	Dotenv dotenv = Dotenv.configure().directory("./src/main/resources").filename("secrets.env").load();

	private String accessKey = dotenv.get("MY_ENV_ACCESS");
	private String secretKey = dotenv.get("MY_ENV_SECRET");
	private String awsRegion = dotenv.get("MY_REGION");
	private String bucketName = "petflicksbucket";

	@Autowired
	ResourceLoader resourceLoader;

	String s3Url = "s3://" + bucketName + "/";;// url syntax s3Url + "foldername"/"filename" in addition

	public void downloadS3(String s3Url) throws IOException {
		Resource resource = resourceLoader.getResource(s3Url);
		File downloadedS3Object = new File(resource.getFilename());

		try (InputStream inputStream = resource.getInputStream()) {
			Files.copy(inputStream, downloadedS3Object.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public void uploadS3(File file, String s3Url) throws IOException {
		WritableResource resource = (WritableResource) resourceLoader.getResource(s3Url);

		try (OutputStream outputStream = resource.getOutputStream()) {
			Files.copy(file.toPath(), outputStream);
		}
	}

}