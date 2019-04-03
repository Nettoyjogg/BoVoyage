package fr.adaming.dao;
import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;


public interface IClientDao {

	public List<Client> recupererToutClient(Conseiller co);

	public Client ajouterClient(Client c);

	public int modifierClient(Client c);

	public int supprimerClient(Client c);

	public Client rechercherClientParId(Client c);
	
	public Client existe(Client c);
	
	public Client recupererClientParMail(String mail);
	
}
