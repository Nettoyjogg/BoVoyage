package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="clients")
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_c")
	private int idClient;
	@Column(name = "nom_c")
	private String nomClient;
	@Column(name = "prenom_c")
	private String prenomClient;
	@Column(name = "civilite_c")
	private String civilite;
	@Column(name = "adresse_c")
	private String adresse;
	@Column(name = "telephone_c")
	private String telephone;
	@Column(name = "numSequence_c")
	private int numeroSequentiel;
	@Column(name = "date_c")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Column(name = "numCarte_c")
	private long numCarteB;
	@Column(name = "solvabilite_c")
	private boolean solvabilite;
	@Column(name = "solde_c")
	private double solde;
	@Column(name = "mail_c")
	private String mailClient;
	@Column(name = "mdp_c")
	private String mdpClient;
	@Column(name = "active_c")
	private boolean active;
	
	
	
	//Transition de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name = "co_id", referencedColumnName = "id_co")
	private Conseiller conseiller;
	
	@OneToMany(mappedBy="client")
	private List<Role> roles;
	
	
	@OneToMany(mappedBy="client")
	private List<Commande> listeCommande;
	//Constructeurs
	public Client() {
		super();
	}
	


	public Client(String nomClient, String prenomClient, String civilite, String adresse, String telephone,
			int numeroSequentiel, Date dateNaissance, long numCarteB, boolean solvabilite, double solde,
			String mailClient, String mdpClient, boolean active) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.civilite = civilite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.numeroSequentiel = numeroSequentiel;
		this.dateNaissance = dateNaissance;
		this.numCarteB = numCarteB;
		this.solvabilite = solvabilite;
		this.solde = solde;
		this.mailClient = mailClient;
		this.mdpClient = mdpClient;
		this.active = active;

	}



	public Client(int idClient, String nomClient, String prenomClient, String civilite, String adresse,
			String telephone, int numeroSequentiel, Date dateNaissance, long numCarteB, boolean solvabilite,
			double solde, String mailClient, String mdpClient, boolean active) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.civilite = civilite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.numeroSequentiel = numeroSequentiel;
		this.dateNaissance = dateNaissance;
		this.numCarteB = numCarteB;
		this.solvabilite = solvabilite;
		this.solde = solde;
		this.mailClient = mailClient;
		this.mdpClient = mdpClient;
		this.active = active;

	}



	//Getter et setters
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getNumeroSequentiel() {
		return numeroSequentiel;
	}
	public void setNumeroSequentiel(int numeroSequentiel) {
		this.numeroSequentiel = numeroSequentiel;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public long getNumCarteB() {
		return numCarteB;
	}
	public void setNumCarteB(long numCarteB) {
		this.numCarteB = numCarteB;
	}

	public boolean isSolvabilite() {
		return solvabilite;
	}

	public void setSolvabilite(boolean solvabilite) {
		this.solvabilite = solvabilite;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getMailClient() {
		return mailClient;
	}
	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}
	public String getMdpClient() {
		return mdpClient;
	}
	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}
	
	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	
	
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}


	//To string

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", civilite=" + civilite + ", adresse=" + adresse + ", telephone=" + telephone + ", numeroSequentiel="
				+ numeroSequentiel + ", dateNaissance=" + dateNaissance + ", numCarteB=" + numCarteB + ", solvabilite="
				+ solvabilite + ", solde=" + solde + ", mailClient=" + mailClient + ", mdpClient=" + mdpClient
				+ ", active=" + active + ", conseiller=" + conseiller + ", roles=" + roles + ", listeCommande="
				+ listeCommande + "]";
	}
	
	

}
