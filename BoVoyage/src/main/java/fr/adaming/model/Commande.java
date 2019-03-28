package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	// Déclaration des variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_com")
	private int idCommande;
	@Column(name = "numero_com")
	private int numeroCommande;
	@Column(name = "etat_com")
	private String etat;
	@Column(name = "assurance_com")
	private String assurance;
	@Embedded
	private Formule formule;
	@Embedded
	private PrestationHebergement prestation;

	// Transition de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name = "c_id", referencedColumnName = "id_c")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "v_id", referencedColumnName = "id_v")
	private Voyage voyage;

	// Déclaration des constructeurs
	public Commande() {
		super();
	}

	public Commande(int numeroCommande, String etat, String assurance, Formule formule,
			PrestationHebergement prestation, Client client, Voyage voyage) {
		super();
		this.numeroCommande = numeroCommande;
		this.etat = etat;
		this.assurance = assurance;
		this.formule = formule;
		this.prestation = prestation;
		this.client = client;
		this.voyage = voyage;
	}

	public Commande(int idCommande, int numeroCommande, String etat, String assurance, Formule formule,
			PrestationHebergement prestation, Client client, Voyage voyage) {
		super();
		this.idCommande = idCommande;
		this.numeroCommande = numeroCommande;
		this.etat = etat;
		this.assurance = assurance;
		this.formule = formule;
		this.prestation = prestation;
		this.client = client;
		this.voyage = voyage;
	}

	// Déclaration des getters et setters

	public String getEtat() {
		return etat;
	}

	public String getAssurance() {
		return assurance;
	}

	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	public PrestationHebergement getPrestation() {
		return prestation;
	}

	public void setPrestation(PrestationHebergement prestation) {
		this.prestation = prestation;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", numeroCommande=" + numeroCommande + ", etat=" + etat
				+ ", assurance=" + assurance + ", formule=" + formule + ", prestation=" + prestation + ", client="
				+ client + ", voyage=" + voyage + "]";
	}

}
