package com.petflicks.app.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.petflicks.app.Exception.FileStorageException;

@Service
public class VideoServiceImpl implements VideoService{

	   @Value("${app.upload.dir:${user.home}}")
	    public String uploadDir;

	    public String uploadFile(MultipartFile file) {

	    	 String UPLOAD_PATH = "https://boll6436of.execute-api.us-east-2.amazonaws.com/v1/peflicksbucket/";
	         try
	         {
	           //  int read = 0;
	            // byte[] bytes = new byte[1024];
	      
	             OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + file.getName()));
	             
	             out.flush();
	             out.close();
	         } catch (IOException e)
	         {
	             throw new FileStorageException("Error while uploading file. Please try again !!");
	         }
	         return "Data uploaded successfully !!";
	     
	    }
	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	
	
}
