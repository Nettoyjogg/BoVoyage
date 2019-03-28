package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
public class LoginController {
	@Autowired
	private IClientService cService;
	
	@RequestMapping(value="/loginUrl",method=RequestMethod.GET)
	public String affichePageLogin(){
		return "loginPage";
	}
	
	@RequestMapping(value="/logoutUrl",method=RequestMethod.GET)
	public String affichePageLogout(){
		return "indexRedirection";
		
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
