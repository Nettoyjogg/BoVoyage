package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voyages")
public class Voyage implements Serializable{

	private static final long serialVersionUID = 1L;

	//Déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_v")
	private int idVoyage;
	@Column(name = "place_v")
	private int placesLibres;
	@Column(name="datedep_v")
	private Date dateDepart;
	@Column(name="dateret_v")
	private Date dateRetour;
	@Column(name="prix_v")
	private double prix;
	@Column(name="statut_v")
	private boolean statut;
	@Embedded
	private Formule formule;
	@Embedded
	private Destination destination;
	@Embedded
	private PrestationHebergement prestation;
	
	//Déclaration des 3	 CONSTRUCTEURS
	public Voyage() {
		super();
	}
	public Voyage(int placesLibres, Date dateDepart, Date dateRetour, double prix, boolean statut, Formule formule,
			Destination destination, PrestationHebergement prestation) {
		super();
		this.placesLibres = placesLibres;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prix = prix;
		this.statut = statut;
		this.formule = formule;
		this.destination = destination;
		this.prestation = prestation;
	}
	public Voyage(int idVoyage, int placesLibres, Date dateDepart, Date dateRetour, double prix, boolean statut,
			Formule formule, Destination destination, PrestationHebergement prestation) {
		super();
		this.idVoyage = idVoyage;
		this.placesLibres = placesLibres;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prix = prix;
		this.statut = statut;
		this.formule = formule;
		this.destination = destination;
		this.prestation = prestation;
	}
	
	//Déclaration des getters et setters
	public int getIdVoyage() {
		return idVoyage;
	}
	public void setIdVoyage(int idVoyage) {
		this.idVoyage = idVoyage;
	}
	public int getPlacesLibres() {
		return placesLibres;
	}
	public void setPlacesLibres(int placesLibres) {
		this.placesLibres = placesLibres;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Formule getFormule() {
		return formule;
	}
	public void setFormule(Formule formule) {
		this.formule = formule;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public PrestationHebergement getPrestation() {
		return prestation;
	}
	public void setPrestation(PrestationHebergement prestation) {
		this.prestation = prestation;
	}
	
	//To string
	@Override
	public String toString() {
		return "Voyage [idVoyage=" + idVoyage + ", placesLibres=" + placesLibres + ", dateDepart=" + dateDepart
				+ ", dateRetour=" + dateRetour + ", prix=" + prix + ", statut=" + statut + ", formule=" + formule
				+ ", destination=" + destination + ", prestation=" + prestation + "]";
	}
	
	
}
