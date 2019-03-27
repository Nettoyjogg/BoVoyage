package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import java.util.List;

public interface ICommandeService{
	
	public Commande ajouterCommande(Commande com);
	
	public int modifierCommande(Commande com); // permet de changer l'�tat de la commande (en attente, valid�e, refus�e)
	
	public int supprimerCommande(Commande com);
	
	public List<Commande> recupererCommandes(Client c);
	
	public Commande chercherCommandeParId(Commande com);
}