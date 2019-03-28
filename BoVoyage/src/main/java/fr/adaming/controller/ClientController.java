package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/client")
@Scope("session")
public class ClientController {
	
	//transformation de l'association UML en JAVA
		@Autowired
		private IClientService cService;
		
		@Autowired
		private IVoyageService vService;
		
		@Autowired
		private IConseillerService coService;
		
		private Conseiller conseiller;
		
		
		@InitBinder
		public void initBinder(WebDataBinder binder){
			//l'objet WebDataBinder sert à faire le lien entre les paramètre de la requete et les objet Java ICI pour le format de la date
			DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
			
			df.setLenient(false);
			
			//la méthode registerCustomEditor(): à configurer la conversion du param reçu au type de l'attribut
			
			//l'objet CustomDateEditor : sert à lier la date reçu commme param de la requete à l'attribut de l'objet etudiant
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
			
		}
		
	
		@RequestMapping(value = "/liste", method = RequestMethod.GET)
		public ModelAndView afficherVoyage() {
			return new ModelAndView("accueil", "liste", vService.afficherVoyages());
		}
		
		//--------------------FONCTIONNALITE AJOUTER
		@RequestMapping(value="/afficheAjouter",method=RequestMethod.GET)
		public String afficheAjout(Model modele){
			//lier un étudiant au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("cAjout",new Client());
			return "ajout_client";
		}
		
		@RequestMapping(value="/soumettreAjouter",method=RequestMethod.POST)
		public String soumettreAjout(@ModelAttribute("cAjout") Client cIn,RedirectAttributes ra){
		 // appel de la methode service
			Client cOut=cService.ajouterClient(cIn);
			if(cOut.getIdClient()!=0){
				return "redirect:liste";
			}else{
				ra.addFlashAttribute("msg","l'ajout a echoué");
				return "redirect:afficheAjouter";
			}
			
		}
		
		
			

}
