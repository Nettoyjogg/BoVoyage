package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Formule implements Serializable{

	private static final long serialVersionUID = 1L;

	//Déclaration des attibuts
	@Column(name="nom_formule_com")
	private String nomFormule;
	@Column(name = "avion_formule_com")
	private String avion;
	@Embedded
	private Hotel hotel;
	@Embedded
	private Voiture voiture;
	
    //Constructeur
	public Formule() {
		super();
	}

	public Formule(String nomFormule, String avion, Hotel hotel, Voiture voiture) {
		super();
		this.nomFormule = nomFormule;
		this.avion = avion;
		this.hotel = hotel;
		this.voiture = voiture;
	}

	// déclaration des getters et setters
	
	public String getNomFormule() {
		return nomFormule;
	}

	public void setNomFormule(String nomFormule) {
		this.nomFormule = nomFormule;
	}
	
	
	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	
	//To string
	@Override
	public String toString() {
		return "Formule [avion=" + avion + ", hotel=" + hotel + ", voiture=" + voiture + "]";
	}
	
	
	
}
