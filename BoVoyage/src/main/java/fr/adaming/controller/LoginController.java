package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/loginUrl",method=RequestMethod.GET)
	public String affichePageLogin(){
		return "loginPage";
	}
	
	@RequestMapping(value="/logoutUrl",method=RequestMethod.GET)
	public String affichePageLogout(){
		return "loginPage";
	}
	
	@RequestMapping(value="/echecUrl",method=RequestMethod.GET)
	public String afficheEchec(ModelMap modele){
		modele.addAttribute("erreur",true);
		return "loginPage";
	}
	
	@RequestMapping(value="/deniedUrl",method=RequestMethod.GET)
	public String denied(ModelMap modele){
		
		return "deniedPage";
	}
	
	
}
