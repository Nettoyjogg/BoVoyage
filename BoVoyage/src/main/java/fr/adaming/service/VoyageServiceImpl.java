package fr.adaming.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;

@Service("vService")
@Transactional
public class VoyageServiceImpl implements IVoyageService {

	// transformation de l'association UML en JAVA
	@Autowired // utilise by type de nom
	private IVoyageDao voyageDao;
	
	public void setVoyageDao(IVoyageDao voyageDao) {
		this.voyageDao = voyageDao;
	}

	@Override
	public List<Voyage> afficherVoyages() {
		return voyageDao.afficherVoyages();
	}

	@Override
	public Voyage ajouterVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyageDao.ajouterVoyage(v);
	}

	@Override
	public int modifierVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyageDao.modifierVoyage(v);
	}

	@Override
	public int cloreVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyageDao.cloreVoyage(v);
	}

	@Override
	public Voyage rechercherVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return voyageDao.rechercherVoyage(v);
	}

	@Override
	public List<Voyage> rechercherDestination(Destination d) {
		// TODO Auto-generated method stub
		return voyageDao.rechercherDestination(d);
	}

	@Override
	public List<Voyage> rechercherPrix(double min, double max) {
		// TODO Auto-generated method stub
		return voyageDao.rechercherPrix(min, max);
	}

	@Override
	public List<Voyage> rechercherDate(Date depart, Date retour) {
		// TODO Auto-generated method stub
		return voyageDao.rechercherDate(depart, retour);
	}

}
