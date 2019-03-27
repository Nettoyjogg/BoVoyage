package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;

//Composant dao
@Repository
public class ConseillerDaoImpl implements IConseillerDao{

	
	@Autowired
	private SessionFactory sf;
	
	// le setter pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	
	@Override
	public Conseiller existe(Conseiller coIn) {
		//récupérer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		
		//requete HQL
		String req="FROM Conseiller as co WHERE co.mailConseiller=:pMail AND co.mdpConseiller=:pMdp";
		
		//récupérer le query
		Query query = s.createQuery(req);
		
		//passage des params
		
		query.setParameter("pMail", coIn.getMailConseiller());
		query.setParameter("pMdp", coIn.getMdpConseiller());
		
		return (Conseiller) query.uniqueResult();
	}

}
