package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voyage;

public interface IVoyageDao {
	
	public List<Voyage> afficherVoyages();
	
	public Voyage ajouterVoyage(Voyage v);
	
	public int modifierVoyage(Voyage v);
	
	public int cloreVoyage(Voyage v);
	
	public Voyage rechercherVoyage(Voyage v);

}
