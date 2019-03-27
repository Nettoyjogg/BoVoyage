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

import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@Controller
@RequestMapping("/client")
@Scope("session")
public class ClientController {
	
	//transformation de l'association UML en JAVA
		@Autowired
		private IClientService cService;
		
		@Autowired
		private IConseillerService coService;
		
		private Conseiller conseiller;
		
		
		@InitBinder
		public void initBinder(WebDataBinder binder){
			//l'objet WebDataBinder sert � faire le lien entre les param�tre de la requete et les objet Java ICI pour le format de la date
			DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
			
			df.setLenient(false);
			
			//la m�thode registerCustomEditor(): � configurer la conversion du param re�u au type de l'attribut
			
			//l'objet CustomDateEditor : sert � lier la date re�u commme param de la requete � l'attribut de l'objet etudiant
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
			
		}
		
	

		
		
		
		

}
