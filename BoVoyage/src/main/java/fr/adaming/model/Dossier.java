package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dossiers")
public class Dossier implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Déclaration des variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_d")
	private int idDossier;
	@Column(name = "numero_d")
	private int numeroDossier;
	@Column(name = "etat_d")
	private String etat;

	
	//Déclaration des constructeurs
	public Dossier() {
		super();
	}

	public Dossier(int numeroDossier, String etat) {
		super();
		this.numeroDossier = numeroDossier;
		this.etat = etat;
	}

	public Dossier(int idDossier, int numeroDossier, String etat) {
		super();
		this.idDossier = idDossier;
		this.numeroDossier = numeroDossier;
		this.etat = etat;
	}

	
	//Déclaration des getters et setters
	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public int getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(int numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}	
	
	//To String
	@Override
	public String toString() {
		return "Dossier [idDossier=" + idDossier + ", numeroDossier=" + numeroDossier + ", etat=" + etat + "]";
	}
	

}
