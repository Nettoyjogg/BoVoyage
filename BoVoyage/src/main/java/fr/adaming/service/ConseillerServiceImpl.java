package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;


@Service("coService")
@Transactional //ici toute les méthodes de la classe seront transactional ==> peuvent gérer les transaction 
//on peut le mettre sur Dao mais sur Service c'est la bonne méthode en terme d'économie de place 
public class ConseillerServiceImpl implements IConseillerService{

	// transformation de l'association UML en JAVA
		@Autowired //utilise by type de nom
		private IConseillerDao conseillerDao;
	
	
	
	public void setConseillerDao(IConseillerDao conseillerDao) {
			this.conseillerDao = conseillerDao;
		}



	@Override
	public Conseiller existe(Conseiller coIn) {
		return conseillerDao.existe(coIn);
	}

}
