package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl implements IVoyageDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Voyage> afficherVoyages() {
		// recupération du bus
		Session s = sf.getCurrentSession();

		String req = "SELECT v FROM Voyage v";
		Query query = s.createQuery(req);

		List<Voyage> listeV = query.list();

		for (Voyage v : listeV) {
			v.setImg("data:image/png;base64," + Base64.encodeBase64String(v.getPhoto()));
		}

		return listeV;
	}

	@Override
	public Voyage ajouterVoyage(Voyage v) {
		// recupération du bus
		Session s = sf.getCurrentSession();
		v.setStatut(true);
		s.save(v);
		return v;
	}

	@Override
	public int modifierVoyage(Voyage v) {
		// recup le bus
		Session s = sf.getCurrentSession();
		String req = "UPDATE Voyage as v SET  v.placesLibres=:pPlaces, v.dateDepart=:pDDep, v.dateRetour=:pDRet, v.prix=:pPrix, v.statut=:pStat, "
				+ "v.destination.continent=:pCont,v.destination.pays=:pPays, v.photo=:pPhot WHERE v.idVoyage=:pId";
		Query query = s.createQuery(req);

		query.setParameter("pPlaces", v.getPlacesLibres());
		query.setParameter("pDDep", v.getDateDepart());
		query.setParameter("pDRet", v.getDateRetour());
		query.setParameter("pPrix", v.getPrix());
		query.setParameter("pStat", v.isStatut());
		query.setParameter("pCont", v.getDestination().getContinent());
		query.setParameter("pPays", v.getDestination().getPays());
		query.setParameter("pPhot", v.getPhoto());

		query.setParameter("pId", v.getIdVoyage());

		return query.executeUpdate();
	}


	@Override
	public Voyage rechercherVoyage(Voyage v) {
		Session s=sf.getCurrentSession();
		
		String req="FROM Voyage as v WHERE v.idVoyage=:pId";
		
		
		Query queryHQL = s.createQuery(req);
		
		//passage des params
		queryHQL.setParameter("pId", v.getIdVoyage());
	
		return (Voyage) queryHQL.uniqueResult();
	}

	@Override
	public List<Voyage> rechercherDestination(Destination d) {
		// recupération du bus
		Session s = sf.getCurrentSession();

		String req = "SELECT v FROM Voyage v WHERE v.destination=:pDest";
		Query query = s.createQuery(req);
		
		query.setParameter("pDest", d);

		List<Voyage> listeV = query.list();

		for (Voyage v : listeV) {
			v.setImg("data:image/png;base64," + Base64.encodeBase64String(v.getPhoto()));
		}

		return listeV;
	}

	@Override
	public List<Voyage> rechercherPrix(double min, double max) {
		// recupération du bus
		Session s = sf.getCurrentSession();

		String req = "SELECT v FROM Voyage v WHERE v.prix BETWEEN :pMin AND :pMax";
		Query query = s.createQuery(req);
		
		query.setParameter("pMin", min);
		query.setParameter("pMax", max);

		List<Voyage> listeV = query.list();

		for (Voyage v : listeV) {
			v.setImg("data:image/png;base64," + Base64.encodeBase64String(v.getPhoto()));
		}

		return listeV;
	}

	@Override
	public List<Voyage> rechercherDate(Date depart, Date retour) {
		// recupération du bus
		Session s = sf.getCurrentSession();

		String req = "SELECT v FROM Voyage v WHERE v.dateDepart >= :pDep AND v.dateRetour <= :pRet";
		Query query = s.createQuery(req);
		
		query.setParameter("pDep", depart);
		query.setParameter("pRet", retour);

		List<Voyage> listeV = query.list();

		for (Voyage v : listeV) {
			v.setImg("data:image/png;base64," + Base64.encodeBase64String(v.getPhoto()));
		}

		return listeV;
	}

}
