package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Hotel implements Serializable{


	private static final long serialVersionUID = 1L;
	
	//Déclaration des attributs
	@Column(name = "nom_hotel_com")
	private String nomH;
	@Column(name = "place_hotel_com")
	private int nombreEtoile;
	
	//Déclaration des constructeurs
	public Hotel() {
		super();
	}
	public Hotel(String nomH, int nombreEtoile) {
		super();
		this.nomH = nomH;
		this.nombreEtoile = nombreEtoile;
	}
	
	//Déclaration des getters et setters
	public String getNomH() {
		return nomH;
	}
	public void setNomH(String nomH) {
		this.nomH = nomH;
	}
	public int getNombreEtoile() {
		return nombreEtoile;
	}
	public void setNombreEtoile(int nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}
	
	
	//To string
	@Override
	public String toString() {
		return "Hotel [nomH=" + nomH + ", nombreEtoile=" + nombreEtoile + "]";
	}

	
	
}
