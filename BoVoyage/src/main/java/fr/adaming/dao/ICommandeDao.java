package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface ICommandeDao{
	
	public List<Commande> recupererCommandes(Client c);
	
	public Commande ajouterCommande(Commande com);
	
	public int modifierCommande(Commande com); // permet de changer l'état de la commande (en attente, validée, refusée)
	
	public int supprimerCommande(Commande com);
	
	public Commande chercherCommandeParId(Commande com);
}