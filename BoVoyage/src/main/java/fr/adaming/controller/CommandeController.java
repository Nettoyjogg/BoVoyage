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
import fr.adaming.model.Commande;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/commande")
@Scope("session")
public class CommandeController {
	
	//transformation de l'association UML en JAVA
		@Autowired
		private IClientService cService;
		
		@Autowired
		private IVoyageService vService;
		
		@Autowired
		private IConseillerService coService;
		
		@Autowired
		private ICommandeService comService;
		
		private Conseiller conseiller;
		
		private Client client;
		
		
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
			return new ModelAndView("accueil", "liste", comService.recupererCommandes(client));
		}
		
		//--------------------FONCTIONNALITE AJOUTER
		@RequestMapping(value="/afficheAjouter",method=RequestMethod.GET)
		public String afficheAjout(Model modele){
			//lier une commande au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("comAjout",new Commande());
			return "ajout_commande";
		}
		
		@RequestMapping(value="/soumettreAjouter",method=RequestMethod.POST)
		public String soumettreAjout(@ModelAttribute("comAjout") Commande comIn,RedirectAttributes ra){
		 // appel de la methode service
			Commande comOut = comService.ajouterCommande(comIn);
			if(comOut.getIdCommande()!=0){
				return "redirect:liste";
			}else{
				ra.addFlashAttribute("msg","l'ajout a echoué");
				return "redirect:afficheAjouter";
			}
			
		}
		
		
		
		//--------------------FONCTIONNALITE MODIFIER
		@RequestMapping(value="/afficheModifier",method=RequestMethod.GET)
		public String afficheModif(Model modele){
			//lier une commande au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("comModif",new Commande());
			return "modif_commande";
		}
		
		@RequestMapping(value="/soumettreModifier",method=RequestMethod.POST)
		public String soumettreModif(@ModelAttribute("comModif") Commande comIn,RedirectAttributes ra){
		 // appel de la methode service
			int verif = comService.modifierCommande(comIn);
			if(verif!=0){
				return "redirect:liste";
			}else{
				ra.addFlashAttribute("msg","la modification a echoué");
				return "redirect:afficheModifier";
			}
			
		}
		
		
		
		//--------------------FONCTIONNALITE SUPPRIMER
		@RequestMapping(value="/afficheSupprimer",method=RequestMethod.GET)
		public String afficheSuppr(Model modele){
			//lier une commande au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("comSuppr",new Commande());
			return "suppr_commande";
		}
		
		@RequestMapping(value="/soumettreSupprimer",method=RequestMethod.POST)
		public String soumettreSuppr(@ModelAttribute("comSuppr") Commande comIn,RedirectAttributes ra){
		 // appel de la methode service
			int verif = comService.supprimerCommande(comIn);
			if(verif!=0){
				return "redirect:liste";
			}else{
				ra.addFlashAttribute("msg","la suppression a echoué");
				return "redirect:afficheSupprimer";
			}
			
		}
			

}
