package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

@Service("cService")
@Transactional //ici toute les méthodes de la classe seront transactional ==> peuvent gérer les transaction 
//on peut le mettre sur Dao mais sur Service c'est la bonne méthode en terme d'économie de place 
public class ClientServiceImpl implements IClientService{

	// transformation de l'association UML en JAVA
		@Autowired //utilise by type de nom
		private IClientDao clientDao;
		
		
	public void setClientDao(IClientDao clientDao) {
			this.clientDao = clientDao;
		}

	@Override
	public List<Client> recupererToutClient(Conseiller co) {
		return clientDao.recupererToutClient(co);
	}

	@Override
	public Client ajouterClient(Client c) {
		return clientDao.ajouterClient(c);
	}

	@Override
	public int modifierClient(Client c) {
		return clientDao.modifierClient(c);
	}

	@Override
	public int supprimerClient(Client c) {
		return clientDao.supprimerClient(c);
	}

	@Override
	public Client rechercherClientParId(Client c) {
		return clientDao.rechercherClientParId(c);
	}

	@Override
	public Client existe(Client c) {
	return clientDao.existe(c);
	}
		
		
	
}
