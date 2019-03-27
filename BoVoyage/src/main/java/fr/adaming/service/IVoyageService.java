package fr.adaming.service;

import java.util.Date;
import java.util.List;

import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;

public interface IVoyageService {
	
	public List<Voyage> afficherVoyages();

	public Voyage ajouterVoyage(Voyage v);

	public int modifierVoyage(Voyage v);

	public int cloreVoyage(Voyage v);

	public Voyage rechercherVoyage(Voyage v);

	public List<Voyage> rechercherDestination(Destination d);

	public List<Voyage> rechercherPrix(double min, double max);

	public List<Voyage> rechercherDate(Date depart, Date retour);

}
