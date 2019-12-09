package com.project.data;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="prof")
public class Prof {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "code", nullable = false)
	private Integer code;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="departement")
	private String departement;
	
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.MERGE, CascadeType.MERGE})
	@JoinTable(
			name = "pfe_encadrant", 
			joinColumns = @JoinColumn(name = "encadrant_id"), 
			inverseJoinColumns = @JoinColumn(name = "pfe_id")
			)
	private Set<PFE> pfe_encadrant;
	
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.MERGE, CascadeType.MERGE})
	@JoinTable(
			name = "pfe_jury",
			joinColumns = @JoinColumn(name = "jury_id"), 
			inverseJoinColumns = @JoinColumn(name = "pfe_id")
	)
	private Set<PFE> pfe_jury;
	
	
	
	public Prof(){}

	public Prof(String nom, String prenom, String departement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Set<PFE> getPfe_encadrant() {
		return pfe_encadrant;
	}

	public void setPfe_encadrant(Set<PFE> pfe_encadrant) {
		this.pfe_encadrant = pfe_encadrant;
	}

	public Set<PFE> getPfe_jury() {
		return pfe_jury;
	}

	public void setPfe_jury(Set<PFE> pfe_jury) {
		this.pfe_jury = pfe_jury;
	}

	



	
	
	
	
	

}

