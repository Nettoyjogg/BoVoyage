package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public class CommandeDaoImpl implements ICommandeDao {

	@Autowired
	private SessionFactory sf;

	// le setter pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	
	

	@Override
	public List<Commande> recupererCommandes(Client c) {

		// récupérer le bus (session de hibernate
		Session s = sf.getCurrentSession();

		String req = "FROM Commande as com WHERE com.client.idClient=:pId";

		Query queryHQL = s.createQuery(req);

		// passage des params
		queryHQL.setParameter("pId", c.getIdClient());

		return queryHQL.list();
	}
	
	
	@Override
	public Commande ajouterCommande(Commande com) {

		// récupérer le bus (session de hibernate
		Session s = sf.getCurrentSession();
		s.save(com);
		return com;
	}

	@Override
	public int modifierCommande(Commande com) {
		
		// récupérer le bus (session de hibernate
		Session s = sf.getCurrentSession();

		String req = "UPDATE Commande as com SET com.numeroCommande=:pNum, com.etat=:pEtat, com.assurance=:pAssurance com.formule=:pForm, v.prestation=:pPrest WHERE com.idCommande=:pId";

		Query queryHQL = s.createQuery(req);

		// passage des params
		queryHQL.setParameter("pNum", com.getNumeroCommande());
		queryHQL.setParameter("pEtat", com.getEtat());
		queryHQL.setParameter("pAssurance", com.getAssurance());
		queryHQL.setParameter("pForm", com.getFormule());
		queryHQL.setParameter("pPrest", com.getPrestation());
		queryHQL.setParameter("pId", com.getIdCommande());

		return queryHQL.executeUpdate();
	}

	@Override
	public int supprimerCommande(Commande com) {

		// récupérer le bus (session de hibernate
		Session s = sf.getCurrentSession();
				
		String req = "DELETE Commande as com  WHERE com.idCommande=:pId";
		
		//Récupérer un objet de type Query
		Query queryHQL = s.createQuery(req);		
		
		//Passage des paramètres
		queryHQL.setParameter("pId", com.getIdCommande());
		return queryHQL.executeUpdate();
	}


	@Override
	public Commande chercherCommandeParId(Commande com) {

		// récupérer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		
		String req="FROM Commande as com WHERE com.idCommande=:pId";
		
		
		Query queryHQL = s.createQuery(req);
		
		//passage des params
		queryHQL.setParameter("pId", com.getIdCommande());
	
		return (Commande) queryHQL.uniqueResult();
	}

}