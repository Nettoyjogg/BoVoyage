package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Formateur;
import fr.adaming.model.Role;


@Repository // pour dire que c'est un DAO
public class ClientDaoImpl implements IClientDao{

	
	@Autowired
	private SessionFactory sf;
	
	// le setter pour l'injection de d�pendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	
	
	@Override
	public List<Client> recupererToutClient(Conseiller co) {
		//r�cup�rer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		
		String req="FROM Client as c WHERE c.conseiller.idConseiller=:pId";
		
		
		Query queryHQL = s.createQuery(req);
		
		//passage des params
		queryHQL.setParameter("pId", co.getIdConseiller());
	
		return queryHQL.list();
	
	}

	@Override
	public Client ajouterClient(Client c) {
		//r�cup�rer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		c.setActive(true);
		int num = 1+ (int) (Math.random() * 9999);
		c.setNumeroSequentiel(num);
		s.save(c);
		//Test
		Role r = new Role();
		r.setClient(c);
		r.setRoleName("ROLE_CLIENT");
		r.setRoleMail(c.getMailClient());
		r.setRoleMdp(c.getMdpClient());
		r.setRoleActive(c.isActive());
		s.save(r);
		
		return c;
	}

	@Override
	public int modifierClient(Client c) {
		//r�cup�rer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		String req = "UPDATE Client as c SET c.nomClient=:pNom, c.prenomClient=:pPrenom, c.civilite=:pCivilite, c.adresse=:pAdresse, c.telephone=pTelephone,"
				+ " c.numeroSequentiel=:pNumeroSequentiel,c.dateNaissance=:pDateNaissance,c.numCarteB=:pNumCarteB,c.solvabilite=:pSolvabilite,c.solde=:pSolde,"
				+ " c.mailClient=:pMailClient,c.mdpClient=:pMdpClient,c.active=:pActive WHERE c.idClient=:pId";
		
		//R�cup�rer un objet de type Query
		Query query=s.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pNom", c.getNomClient());
		query.setParameter("pPrenom", c.getPrenomClient());
		query.setParameter("pCivilite", c.getCivilite());
		query.setParameter("pAdresse", c.getAdresse());
		query.setParameter("pTelephone", c.getTelephone());
		query.setParameter("pNumeroSequentiel", c.getNumeroSequentiel());
		query.setParameter("pDateNaissance", c.getDateNaissance());
		query.setParameter("pNumCarteB", c.getNumCarteB());
		query.setParameter("pSolvabilite",c.isSolvabilite());
		query.setParameter("pSolde", c.getSolde());
		query.setParameter("pMailClient", c.getMailClient());
		query.setParameter("pMdpClient", c.getMdpClient());
		query.setParameter("pActive", c.isActive());
		query.setParameter("pId", c.getIdClient());


		return query.executeUpdate();
	}

	@Override
	public int supprimerClient(Client c) {
		Session s=sf.getCurrentSession();
		String req = "DELETE Client as c  WHERE c.idClient=:pId";
		
		//R�cup�rer un objet de type Query
		Query query=s.createQuery(req);		
		
		//Passage des param�tres
		query.setParameter("pId", c.getIdClient());
		return query.executeUpdate();
	}

	@Override
	public Client rechercherClientParId(Client c) {
		Session s=sf.getCurrentSession();
		
		String req="FROM Client as c WHERE c.idClient=:pId";
		
		
		Query queryHQL = s.createQuery(req);
		
		//passage des params
		queryHQL.setParameter("pId", c.getIdClient());
	
		return (Client) queryHQL.uniqueResult();
	}




	@Override
	public Client existe(Client c) {
		//r�cup�rer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		
		//requete HQL
		String req="FROM Client as c WHERE c.mailClient=:pMail AND c.mdpClient=:pMdp";
		
		//r�cup�rer le query
		Query query = s.createQuery(req);
		
		//passage des params
		
		query.setParameter("pMail", c.getMailClient());
		query.setParameter("pMdp", c.getMdpClient());
		
		return (Client) query.uniqueResult();
	
	}




	@Override
	public Client recupererClientParMail(String mail) {
		//r�cup�rer le bus (session de hibernate
		Session s=sf.getCurrentSession();
		
		//requete HQL
		String req="FROM Client as c WHERE c.mailClient=:pMail";
		
		//r�cup�rer le query
		Query query = s.createQuery(req);
		
		//passage des params
		
		query.setParameter("pMail", mail);
		
		return (Client) query.uniqueResult();
		
	}

}
