package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

public class Panier implements Serializable {

	private static final long serialVersionUID = 1L;
	// transformation de l'association UML
	List<Commande> listeCommande;

	public Panier() {
		super();
	}

	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	
	//toString
	@Override
	public String toString() {
		return "Panier [listeCommande=" + listeCommande + "]";
	}


}
