package com.petflicks.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petflicks.app.Service.VideoService;

@RestController
@RequestMapping(value = "api/upload")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {

	private VideoService videoServ;

	@Autowired
	public VideoController(VideoService videoServ) {
		super();
		this.videoServ = videoServ;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadVideo(@RequestParam("file") MultipartFile file) {

		videoServ.uploadVideo(file);

	}

}
