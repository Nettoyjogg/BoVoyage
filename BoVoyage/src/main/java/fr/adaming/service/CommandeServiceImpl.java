package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public class CommandeServiceImpl implements ICommandeService {

	// transformation de l'association UML en JAVA
	@Autowired // utilise by type de nom
	private ICommandeDao commandeDao;

	public void setCommandeDao(ICommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

	@Override
	public Commande ajouterCommande(Commande com) {

		return commandeDao.ajouterCommande(com);
	}

	@Override
	public int modifierCommande(Commande com) {
		
		return commandeDao.modifierCommande(com);
	}

	@Override
	public int supprimerCommande(Commande com) {

		return commandeDao.supprimerCommande(com);
	}

	@Override
	public List<Commande> recupererCommandes(Client c) {
		
		return commandeDao.recupererCommandes(c);
	}

	@Override
	public Commande chercherCommandeParId(Commande com) {

		return commandeDao.chercherCommandeParId(com);
	}

}