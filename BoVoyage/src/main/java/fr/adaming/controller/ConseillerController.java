package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/conseiller")
@Scope("session")
public class ConseillerController {
	
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
			return new ModelAndView("accueilConseiller", "liste", vService.afficherVoyages());
		}
		
		

}
