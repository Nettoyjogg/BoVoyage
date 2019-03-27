package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="conseillers")
public class Conseiller implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_co")
	private int idConseiller;
	@Column(name = "nom_co")
	private String nomConseiller;
	@Column(name = "mail_co")
	private String mailConseiller;
	@Column(name = "mdp_co")
	private String mdpConseiller;
	@Column(name = "active_co")
	private boolean active;
	
	//transformation de l'association UML en JAVA
	@OneToMany(mappedBy="conseiller")
	private List<Client> clients;
	
	
	@OneToMany(mappedBy="conseiller")
	private List<Role> roles;
	
	
	//constructeurs
	public Conseiller() {
		super();
	}

	
	public Conseiller(String nomConseiller, String mailConseiller, String mdpConseiller, boolean active) {
		super();
		this.nomConseiller = nomConseiller;
		this.mailConseiller = mailConseiller;
		this.mdpConseiller = mdpConseiller;
		this.active = active;

	}


	public Conseiller(int idConseiller, String nomConseiller, String mailConseiller, String mdpConseiller,
			boolean active) {
		super();
		this.idConseiller = idConseiller;
		this.nomConseiller = nomConseiller;
		this.mailConseiller = mailConseiller;
		this.mdpConseiller = mdpConseiller;
		this.active = active;

	}


	//getter et setter
	public int getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	public String getNomConseiller() {
		return nomConseiller;
	}
	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}
	public String getMailConseiller() {
		return mailConseiller;
	}
	public void setMailConseiller(String mailConseiller) {
		this.mailConseiller = mailConseiller;
	}
	public String getMdpConseiller() {
		return mdpConseiller;
	}
	public void setMdpConseiller(String mdpConseiller) {
		this.mdpConseiller = mdpConseiller;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
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
		return "Conseiller [idConseiller=" + idConseiller + ", nomConseiller=" + nomConseiller + ", mailConseiller="
				+ mailConseiller + ", mdpConseiller=" + mdpConseiller + ", active=" + active + ", clients=" + clients
				+ ", roles=" + roles + "]";
	}
	
	

}
