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

		s.save(v);
		return v;
	}

	@Override
	public int modifierVoyage(Voyage v) {
		// recup le bus
		Session s = sf.getCurrentSession();
		String req = "UPDATE Voyage v SET " + "v.placesLibres=:pPlaces, " + "v.dateDepart=:pDDep, "
				+ "v.dateRetour=:pDRet, " + "v.prix=:pPrix, " + "v.statut=:pStat, " + "v.formule=:pForm, "
				+ "v.destination=:pDest, " + "v.prestation=:pPrest, " + "v.photo=:pPhot " + "WHERE v.idVoyage=:pId";
		Query query = s.createQuery(req);

		query.setParameter("pPlaces", v.getPlacesLibres());
		query.setParameter("pDDep", v.getDateDepart());
		query.setParameter("pDRet", v.getDateRetour());
		query.setParameter("pPrix", v.getPrix());
		query.setParameter("pStat", v.isStatut());
		query.setParameter("pForm", v.getFormule());
		query.setParameter("pDest", v.getDestination());
		query.setParameter("pPrest", v.getPrestation());
		query.setParameter("pPhot", v.getPhoto());

		query.setParameter("pId", v.getIdVoyage());

		return query.executeUpdate();
	}

	@Override
	public int cloreVoyage(Voyage v) {
		// A definir si on arrive pas à se dévir de la méthode modifier
		return 0;
	}

	@Override
	public Voyage rechercherVoyage(Voyage v) {
		Session s = sf.getCurrentSession();

		Voyage vOut = (Voyage) s.get(Voyage.class, v.getIdVoyage());
		vOut.setImg("data:image/png;base64," + Base64.encodeBase64String(vOut.getPhoto()));
		return vOut;
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

		String req = "SELECT v FROM Voyage v WHERE v.prix=:";
		Query query = s.createQuery(req);

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

		String req = "SELECT v FROM Voyage v";
		Query query = s.createQuery(req);

		List<Voyage> listeV = query.list();

		for (Voyage v : listeV) {
			v.setImg("data:image/png;base64," + Base64.encodeBase64String(v.getPhoto()));
		}

		return listeV;
	}

}
