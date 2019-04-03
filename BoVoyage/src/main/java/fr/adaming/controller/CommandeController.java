package fr.adaming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import fr.adaming.model.Formule;
import fr.adaming.model.Hotel;
import fr.adaming.model.PrestationHebergement;
import fr.adaming.model.Voiture;
import fr.adaming.model.Voyage;
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
		
		
		@PostConstruct
		public void init(){
			// récupérer le context de Spring Security
			Authentication authCxt = SecurityContextHolder.getContext().getAuthentication();
			
			// récupérer le j_username de login.jsp (dans balise form de connexion) qui dans notre cas est le mail
			String mail = authCxt.getName();
			
			this.client = cService.recupererClientParMail(mail);
		}
		
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
			return new ModelAndView("panier", "liste", comService.recupererCommandes(client));
		}
		
		//--------------------FONCTIONNALITE AJOUTER
		@RequestMapping(value="/afficheAjouter",method=RequestMethod.GET)
		public String afficheAjout(Model modele){
			
			Commande com=new Commande();
			com.setPrestation(new PrestationHebergement());
			
			Formule forom=new Formule();
			forom.setHotel(new Hotel());
			forom.setVoiture(new Voiture());
			com.setFormule(forom);
			
			
			//lier une commande au modèle MVC afin de l'utiliser dans le formulaire
			modele.addAttribute("comAjout",com);
			
			// ajout des formules proposées
			List<Formule> formules = new ArrayList<Formule>();
			
			Formule f1 = new Formule();
			f1.setNomFormule("Avion");
			formules.add(f1);
			
			Formule f2 = new Formule();
			f2.setNomFormule("Hotel");
			formules.add(f2);
			
			Formule f3 = new Formule();
			f3.setNomFormule("AvionHotel");
			formules.add(f3);
			
			Formule f4 = new Formule();
			f4.setNomFormule("AvionVoiture");
			formules.add(f4);
			
			Formule f5 = new Formule();
			f5.setNomFormule("AvionHotelVoiture");
			formules.add(f5);

			modele.addAttribute("formules", formules);
			
			
			// ajout des hôtels proposées
			List<Hotel> hotels = new ArrayList<Hotel>();

			Hotel h1 = new Hotel("Hotel mondial",2);
			hotels.add(h1);

			Hotel h2 = new Hotel("Hotel mondial",3);
			hotels.add(h2);
			
			modele.addAttribute("hotels",hotels);
			
			
			// ajout des voitures proposées
			List<Voiture> voitures = new ArrayList<Voiture>();

			Voiture v1 = new Voiture("A","Hertz",2);
			voitures.add(v1);

			Voiture v2 = new Voiture("C","Hertz",5);
			voitures.add(v2);
						
			modele.addAttribute("voitures",voitures);
			
			
			// ajout des prestations proposées
			List<PrestationHebergement> prestations = new ArrayList<PrestationHebergement>();
			
			PrestationHebergement p1 = new PrestationHebergement();
			p1.setType("Hebergement seul");
			prestations.add(p1);
			
			PrestationHebergement p2 = new PrestationHebergement();
			p2.setType("Petit dejeuner");
			prestations.add(p2);
			
			PrestationHebergement p3 = new PrestationHebergement();
			p3.setType("Demi-pension");
			prestations.add(p3);
			
			PrestationHebergement p4 = new PrestationHebergement();
			p4.setType("Pension complete");
			prestations.add(p4);
			
			modele.addAttribute("prestations",prestations);
			
			
			//ça sert pour créer une liste des voyages
			List<Voyage> voyages = vService.afficherVoyages();
			
			modele.addAttribute("listevoyage", voyages);
			

			List<Voyage> testlist = new ArrayList<Voyage>();
			
			for (Voyage voy : voyages) {


				Voyage e = new Voyage();
				e.setIdVoyage(voy.getIdVoyage());
				e.setDestination(voy.getDestination());
				testlist.add(e);
				
			}
			
			modele.addAttribute("listeiddest",testlist);
			
			return "ajout_commande";
		}
		
		@RequestMapping(value="/soumettreAjouter",method=RequestMethod.POST)
		public String soumettreAjout(@ModelAttribute("comAjout") Commande comIn,RedirectAttributes ra){
		 // appel de la methode service
			Commande comOut = comService.ajouterCommande(comIn);
			comOut.setClient(client);
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
			
			// ajout des formules proposées
			List<Formule> formules = new ArrayList<Formule>();
			
			Formule f1 = new Formule();
			f1.setNomFormule("Avion");
			formules.add(f1);
			
			Formule f2 = new Formule();
			f2.setNomFormule("Hotel");
			formules.add(f2);
			
			Formule f3 = new Formule();
			f3.setNomFormule("AvionHotel");
			formules.add(f3);
			
			Formule f4 = new Formule();
			f4.setNomFormule("AvionVoiture");
			formules.add(f4);
			
			Formule f5 = new Formule();
			f5.setNomFormule("AvionHotelVoiture");
			formules.add(f5);

			modele.addAttribute("formules", formules);
			
			
			// ajout des hôtels proposées
			List<Hotel> hotels = new ArrayList<Hotel>();

			Hotel h1 = new Hotel("Hôtel mondial",2);
			hotels.add(h1);

			Hotel h2 = new Hotel("Hôtel mondial",3);
			hotels.add(h2);
			
			modele.addAttribute("hotels",hotels);
			
			
			// ajout des voitures proposées
			List<Voiture> voitures = new ArrayList<Voiture>();

			Voiture v1 = new Voiture("A","Hertz",2);
			voitures.add(v1);

			Voiture v2 = new Voiture("C","Hertz",5);
			voitures.add(v2);
						
			modele.addAttribute("voitures",voitures);
			
			
			// ajout des prestations proposées
			List<PrestationHebergement> prestations = new ArrayList<PrestationHebergement>();
			
			PrestationHebergement p1 = new PrestationHebergement();
			p1.setType("Hébergement seul");
			prestations.add(p1);
			
			PrestationHebergement p2 = new PrestationHebergement();
			p2.setType("Petit déjeuner");
			prestations.add(p2);
			
			PrestationHebergement p3 = new PrestationHebergement();
			p3.setType("Demi-pension");
			prestations.add(p3);
			
			PrestationHebergement p4 = new PrestationHebergement();
			p4.setType("Pension complète");
			prestations.add(p4);
			
			modele.addAttribute("prestations",prestations);
			
			return "modif_commande";
		}
		
		@RequestMapping(value="/soumettreModifier",method=RequestMethod.POST)
		public String soumettreModif(@ModelAttribute("comModif") Commande comIn,RedirectAttributes ra){
		 // appel de la methode service

			System.out.println(comIn);
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
