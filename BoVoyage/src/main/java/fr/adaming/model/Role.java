package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	//constructeur 
	public Role() {
		super();
	}
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
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

	
	
	
}
