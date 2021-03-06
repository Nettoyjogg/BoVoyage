package fr.adaming.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@RequestMapping("/voyage")
// aucasou ajouter Session scope
public class VoyageController {

	@Autowired
	private IVoyageService vService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// l'objet WebDataBinder sert � faire le lien entre les param�tre de la
		// requete et les objet Java ICI pour le format de la date
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		// la m�thode registerCustomEditor(): � configurer la conversion du
		// param re�u au type de l'attribut

		// l'objet CustomDateEditor : sert � lier la date re�u commme param de
		// la requete � l'attribut de l'objet etudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficherVoyage() {

		List<Voyage> lOut = new ArrayList<Voyage>();
		int a = vService.afficherVoyages().size();
		for (int i = 0; i<a ; i++) {
			if (vService.afficherVoyages().get(i).isStatut()) {
				lOut.add(vService.afficherVoyages().get(i));
			}

		}

		return new ModelAndView("accueil", "liste", lOut);
	}
	
	@RequestMapping(value="photoVoyage",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoVoy(int idVoyage) throws IOException{
		Voyage v=new Voyage();
		v.setIdVoyage(idVoyage);
		Voyage vOut =vService.rechercherVoyage(v);
		return IOUtils.toByteArray(new ByteArrayInputStream(vOut.getPhoto()));
	}

	// ========================ajout d'un voyage================

	@RequestMapping(value = "/afficheAjouter", method = RequestMethod.GET)
	public String afficheAjout(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vAjout", new Voyage());
		return "ajout_voyage";
	}

	@RequestMapping(value = "/soumettreAjouterVoyage", method = RequestMethod.POST)
	public String soumettreAjout(@ModelAttribute("vAjout") Voyage v,MultipartFile file, RedirectAttributes ra) throws IOException {
		// appel methode service
		
		if(!file.isEmpty()){v.setPhoto(file.getBytes());}
		
		Voyage vOut = vService.ajouterVoyage(v);

		if (vOut.getIdVoyage() != 0) {
			return "redirect:liste";
		} else {
			ra.addFlashAttribute("msg", "echec de l'ajout");
			return "redirect:afficheAjouter";
		}
	}

	// ========================modifier un voyage================

	@RequestMapping(value = "/afficheModifier", method = RequestMethod.GET)
	public String afficheModif(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vModif", new Voyage());
		return "modification_voyage";
	}

	@RequestMapping(value = "/soumettreModifierVoyage", method = RequestMethod.POST)
	public String soumettreModif(@ModelAttribute("vModif") Voyage v, RedirectAttributes ra) {
		// appel methode service
		int verif = vService.modifierVoyage(v);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			ra.addFlashAttribute("msg", "echec de la modification");
			return "redirect:afficheModifier";
		}
	}

	// ========================clore un voyage================

	@RequestMapping(value = "/afficheClore", method = RequestMethod.GET)
	public String afficheClore(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vClot", new Voyage());
		return "cloture_voyage";
	}

	@RequestMapping(value = "/soumettreClore", method = RequestMethod.POST)
	public String soumettreClore(@ModelAttribute("vClot") Voyage v, RedirectAttributes ra) {
		// appel methode service
		
		Voyage vOut = vService.rechercherVoyage(v);
		if (vOut != null) {
		vOut.setStatut(false);
		vService.modifierVoyage(vOut);

		
			return "redirect:liste";
		} else {
			ra.addFlashAttribute("msg", "echec de la cloture, le voyage n'existe pas");
			return "redirect:afficheClore";
		}
	
	}
	
	// ========================Supprimer un voyage================

	@RequestMapping(value = "/afficheSupprime", method = RequestMethod.GET)
	public String afficheSupprim(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vSuppr", new Voyage());
		return "supprimer_voyage";
	}

	@RequestMapping(value = "/soumettreSupprimerVoyage", method = RequestMethod.POST)
	public String soumettreSupprim(@ModelAttribute("vSuppr") Voyage v, RedirectAttributes ra) {
		// appel methode service
		
		Voyage vOut = vService.rechercherVoyage(v);
		if (vOut != null) {
		vService.supprimerVoyage(v);

		
			return "redirect:liste";
		} else {
			ra.addFlashAttribute("msg", "echec de la suppression, le voyage n'existe pas");
			return "redirect:afficheSupprime";
		}
	
	}
	
	
	
	// ====================rechercher un voyage================

	@RequestMapping(value = "/afficheRechercher", method = RequestMethod.GET)
	public String afficheRec(Model model) {
		List<Voyage> voyages = vService.afficherVoyages();
		
		model.addAttribute("listevoyage", voyages);
		
		List<Integer> ids = new ArrayList<Integer>();
		List<Destination> idest = new ArrayList<Destination>();
		List<Voyage> testlist = new ArrayList<Voyage>();
		
		for (Voyage voy : voyages) {
			ids.add(voy.getIdVoyage());
			idest.add(voy.getDestination());

			Voyage e = new Voyage();
			e.setIdVoyage(voy.getIdVoyage());
			e.setDestination(voy.getDestination());
			testlist.add(e);
			
		}
		
		
		model.addAttribute("listeId",ids);
		model.addAttribute("listeDest",idest);
		model.addAttribute("listeiddest",testlist);
		
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vRec", new Voyage());
		return "recherche_voyage";
	}

	@RequestMapping(value = "/soumettreRechercherVoyage", method = RequestMethod.POST)
	public ModelAndView soumettreRec(@ModelAttribute("vRec") Voyage v, RedirectAttributes ra) {
		// appel methode service
		Voyage vOut = vService.rechercherVoyage(v);

		if (vOut != null) {
			ModelAndView Modele1 = new ModelAndView("recherche_voyage", "voyage", vOut);
			
			return Modele1;
		} else {
			ra.addFlashAttribute("msg", "Le voyage que vous recherchez n'existe pas");
			return new ModelAndView("recherche_voyage");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ==================== actualiser la liste des voyages en specifiant une
	// destination, des dates, des prix================

	// destination

	@RequestMapping(value = "/afficheDestination", method = RequestMethod.GET)
	public String afficheDest(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vDest", new Voyage());
		return "destination_voyage";
	}

	@RequestMapping(value = "/soumettreDestination", method = RequestMethod.POST)
	public ModelAndView soumettreDest(@ModelAttribute("vDest") Destination d, RedirectAttributes ra) {
		// appel methode service
		List<Voyage> lOut = vService.rechercherDestination(d);

		if (lOut != null) {
			return new ModelAndView("accueil", "liste", lOut);
		} else {
			ra.addFlashAttribute("msg",
					"Il n'y a pas de voyage pr�vu pour la destination que vous recherchez actuellement, revenez plus tard");
			return new ModelAndView("accueil");
		}
	}

	// dates

	@RequestMapping(value = "/afficheDate", method = RequestMethod.GET)
	public String afficheDate(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vDate", new Voyage());
		return "date_voyage";
	}

	@RequestMapping(value = "/soumettreDate", method = RequestMethod.POST)
	public ModelAndView soumettreDate(@ModelAttribute("vDate") Date depart, Date retour, RedirectAttributes ra) {
		// appel methode service
		List<Voyage> lOut = vService.rechercherDate(depart, retour);

		if (lOut != null) {
			return new ModelAndView("accueil", "liste", lOut);
		} else {
			ra.addFlashAttribute("msg",
					"Il n'y a pas de voyage pr�vu pour les dates que vous recherchez actuellement, revenez plus tard");
			return new ModelAndView("accueil");
		}
	}

	// prix

	@RequestMapping(value = "/affichePrix", method = RequestMethod.GET)
	public String affichePrix(Model model) {
		// lier le voyage au mvc pour le formulaire
		model.addAttribute("vPrix", new Voyage());
		return "prix_voyage";
	}

	@RequestMapping(value = "/soumettrePrix", method = RequestMethod.POST)
	public ModelAndView soumettrePrix(@ModelAttribute("vPrix") double min, double max, RedirectAttributes ra) {
		// appel methode service
		List<Voyage> lOut = vService.rechercherPrix(min, max);

		if (lOut != null) {
			return new ModelAndView("accueil", "liste", lOut);
		} else {
			ra.addFlashAttribute("msg",
					"Il n'y a pas de voyage pr�vu dans la tranche de prix que vous recherchez actuellement, revenez plus tard");
			return new ModelAndView("accueil");
		}
	}
	
}


