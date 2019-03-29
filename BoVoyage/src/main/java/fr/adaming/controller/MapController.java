package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {

	@RequestMapping("/display")
	public String afficherMap(){
		
		return "map";
		
	}
}
