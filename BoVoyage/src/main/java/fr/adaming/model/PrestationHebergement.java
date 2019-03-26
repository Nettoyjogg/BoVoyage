package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrestationHebergement implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	//déclaration des attributs
	@Column(name = "type_presta_v")
	private String type;

	//Constructeurs
	public PrestationHebergement() {
		super();
	}

	public PrestationHebergement(String type) {
		super();
		this.type = type;
	}
	
	//Getters et setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	//To string
	@Override
	public String toString() {
		return "PrestationHebergement [type=" + type + "]";
	}
	
	

}
