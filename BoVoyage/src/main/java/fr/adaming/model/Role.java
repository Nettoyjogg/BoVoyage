package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable{


	private static final long serialVersionUID = 1L;
	
	//déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_r")
	private int id;
	@Column(name="roleName_r")
	private String roleName;
	@Column(name="roleMail_r")
	private String roleMail;
	@Column(name="roleMdp_r")
	private String roleMdp;
	@Column(name="roleActive_r")
	private boolean roleActive;
	
	
	//Transformation de l'associtation UML en JAVA
	@ManyToOne
	@JoinColumn(name="co_id",referencedColumnName="id_co")
	private Conseiller conseiller;
	
	@ManyToOne
	@JoinColumn(name="c_id",referencedColumnName="id_c")
	private Client client;
	
	
	//constructeur 
	public Role() {
		super();
	}

	public Role(String roleName, String roleMail, String roleMdp, boolean roleActive, Conseiller conseiller,
			Client client) {
		super();
		this.roleName = roleName;
		this.roleMail = roleMail;
		this.roleMdp = roleMdp;
		this.roleActive = roleActive;
		this.conseiller = conseiller;
		this.client = client;
	}

	public Role(int id, String roleName, String roleMail, String roleMdp, boolean roleActive, Conseiller conseiller,
			Client client) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleMail = roleMail;
		this.roleMdp = roleMdp;
		this.roleActive = roleActive;
		this.conseiller = conseiller;
		this.client = client;
	}



	//getter et setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public String getRoleMail() {
		return roleMail;
	}

	public void setRoleMail(String roleMail) {
		this.roleMail = roleMail;
	}

	public String getRoleMdp() {
		return roleMdp;
	}

	public void setRoleMdp(String roleMdp) {
		this.roleMdp = roleMdp;
	}

	public boolean isRoleActive() {
		return roleActive;
	}

	public void setRoleActive(boolean roleActive) {
		this.roleActive = roleActive;
	}

	
	//to string
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleMail=" + roleMail + ", roleMdp=" + roleMdp
				+ ", roleActive=" + roleActive + ", conseiller=" + conseiller + ", client=" + client + "]";
	}

	


	
	
	
}
