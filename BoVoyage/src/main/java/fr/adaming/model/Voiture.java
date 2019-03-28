package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Voiture implements Serializable{


	private static final long serialVersionUID = 1L;

	//Déclaration des attributs
	@Column(name = "categorie_voiture_com")
	private String categorie;
	@Column(name = "loueur_voiture_com")
	private String nomLoueur;
	@Column(name = "place_voiture_com")
	private int nombrePlace;
	
	//Constructeurs
	public Voiture() {
		super();
	}
	public Voiture(String categorie, String nomLoueur, int nombrePlace) {
		super();
		this.categorie = categorie;
		this.nomLoueur = nomLoueur;
		this.nombrePlace = nombrePlace;
	}
	
	//Déclaration des getters et setters
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getNomLoueur() {
		return nomLoueur;
	}
	public void setNomLoueur(String nomLoueur) {
		this.nomLoueur = nomLoueur;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	
	//To string
	@Override
	public String toString() {
		return "Voiture [categorie=" + categorie + ", nomLoueur=" + nomLoueur + ", nombrePlace=" + nombrePlace + "]";
	}
	
	
	
	
}
