package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import java.util.List;

public interface ICommandeService{
	
	public Commande ajouterCommande(Commande com);
	
	public int modifierCommande(Commande com); // permet de changer l'état de la commande (en attente, validée, refusée)
	
	public int supprimerCommande(Commande com);
	
	public List<Commande> recupererCommandes(Client c);
	
	public Commande chercherCommandeParId(Commande com);
}