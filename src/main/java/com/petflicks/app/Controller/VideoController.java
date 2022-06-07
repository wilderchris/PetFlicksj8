package com.petflicks.app.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petflicks.app.Service.VideoService;

@RestController
@RequestMapping(value = "api/upload")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {

	private VideoService vidServ;
	
	
	
	public String uploadVideo(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {    
		vidServ.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}
	
}
