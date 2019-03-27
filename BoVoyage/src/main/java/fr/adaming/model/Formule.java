package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Formule implements Serializable{

	private static final long serialVersionUID = 1L;

	//D�claration des attibuts
	@Column(name = "avion_formule_v")
	private String avion;
	@Embedded
	private Hotel hotel;
	@Embedded
	private Voiture voiture;
	
    //Constructeur
	public Formule() {
		super();
	}

	public Formule(String avion, Hotel hotel, Voiture voiture) {
		super();
		this.avion = avion;
		this.hotel = hotel;
		this.voiture = voiture;
	}

	// d�claration des getters et setters
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