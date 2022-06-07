package com.petflicks.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface VideoService {

	public void store(MultipartFile file);
	
	
	
}
