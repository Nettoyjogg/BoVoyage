package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	private Date dateNaissance;
	@Column(name = "numCarte_c")
	private long numCarteB;
	@Column(name = "solvabilite_c")
	private double solvabilite;
	@Column(name = "mail_c")
	private String mailClient;
	@Column(name = "mdp_c")
	private String mdpClient;
	
	//Constructeurs
	public Client() {
		super();
	}
	public Client(String nomClient, String prenomClient, String civilite, String adresse, String telephone,
			int numeroSequentiel, Date dateNaissance, long numCarteB, double solvabilite, String mailClient,
			String mdpClient) {
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
		this.mailClient = mailClient;
		this.mdpClient = mdpClient;
	}
	public Client(int idClient, String nomClient, String prenomClient, String civilite, String adresse,
			String telephone, int numeroSequentiel, Date dateNaissance, long numCarteB, double solvabilite,
			String mailClient, String mdpClient) {
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
		this.mailClient = mailClient;
		this.mdpClient = mdpClient;
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
	public double getSolvabilite() {
		return solvabilite;
	}
	public void setSolvabilite(double solvabilite) {
		this.solvabilite = solvabilite;
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
	
	
	//To string
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", civilite=" + civilite + ", adresse=" + adresse + ", telephone=" + telephone + ", numeroSequentiel="
				+ numeroSequentiel + ", dateNaissance=" + dateNaissance + ", numCarteB=" + numCarteB + ", solvabilite="
				+ solvabilite + ", mailClient=" + mailClient + ", mdpClient=" + mdpClient + "]";
	}
	
	

}
