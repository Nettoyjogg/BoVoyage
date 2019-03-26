package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Destination implements Serializable{


	private static final long serialVersionUID = 1L;
	
	//Déclaration des attributs
	@Column(name = "continent_desti_v")
	private String continent;
	@Column(name = "pays_desti_v")
	private String pays;
	
	//Constructeurs
	public Destination() {
		super();
	}
	public Destination(String continent, String pays) {
		super();
		this.continent = continent;
		this.pays = pays;
	}
	
	//getters et setters
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	//To string
	@Override
	public String toString() {
		return "Destination [continent=" + continent + ", pays=" + pays + "]";
	}
	
	

	

}
