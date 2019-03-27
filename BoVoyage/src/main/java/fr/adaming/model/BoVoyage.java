package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bovoyages")
public class BoVoyage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_bo")
	private int idBoVoyage;
	@Column(name = "mail_bo")
	private String mailBoVoyage;
	@Column(name = "telephone_bo")
	private String telephoneBoVoyage;
	
	//Transition de l'association UML en JAVA
	@OneToMany
	@JoinColumn(name="v_id",referencedColumnName="id_v")
	private List<Voyage> listeVoyage;
	
	//constructeur
	public BoVoyage() {
		super();
	}
	public BoVoyage(String mailBoVoyage, String telephoneBoVoyage) {
		super();
		this.mailBoVoyage = mailBoVoyage;
		this.telephoneBoVoyage = telephoneBoVoyage;
	}
	public BoVoyage(int idBoVoyage, String mailBoVoyage, String telephoneBoVoyage) {
		super();
		this.idBoVoyage = idBoVoyage;
		this.mailBoVoyage = mailBoVoyage;
		this.telephoneBoVoyage = telephoneBoVoyage;
	}
	
	//getter et setter
	public int getIdBoVoyage() {
		return idBoVoyage;
	}
	public void setIdBoVoyage(int idBoVoyage) {
		this.idBoVoyage = idBoVoyage;
	}
	public String getMailBoVoyage() {
		return mailBoVoyage;
	}
	public void setMailBoVoyage(String mailBoVoyage) {
		this.mailBoVoyage = mailBoVoyage;
	}
	public String getTelephoneBoVoyage() {
		return telephoneBoVoyage;
	}
	public void setTelephoneBoVoyage(String telephoneBoVoyage) {
		this.telephoneBoVoyage = telephoneBoVoyage;
	}
	
	
	public List<Voyage> getListeVoyage() {
		return listeVoyage;
	}
	public void setListeVoyage(List<Voyage> listeVoyage) {
		this.listeVoyage = listeVoyage;
	}
	@Override
	public String toString() {
		return "BoVoyage [idBoVoyage=" + idBoVoyage + ", mailBoVoyage=" + mailBoVoyage + ", telephoneBoVoyage="
				+ telephoneBoVoyage + "]";
	}
	
	
	

}
