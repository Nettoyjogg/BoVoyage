package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	//transformation de l'association UML en JAVA
		@Autowired
		private IClientService cService;
		
		@Autowired
		private IConseillerService coService;
		
		
		

}
