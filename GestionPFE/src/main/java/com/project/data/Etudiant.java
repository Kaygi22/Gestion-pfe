package com.project.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etudiant")
public class Etudiant {

	@Id
	@Column(name = "cne_etudiant", nullable = false)
	private String CNE;
	
	@Column(name="nom")
	private String Nom;
	
	@Column(name="prenom")
	private String Prenom;
	
	@Column(name="filiere")
	private String Filiere;
	
	public Etudiant() {
		
	}
	
	public Etudiant(String pCIN, String pNom, String pPrenom, String pFiliere) {
		this.CNE = pCIN;
		this.Nom = pNom;
		this.Prenom = pPrenom;
		this.Filiere = pFiliere;
	}

	public String getCNE() {
		return CNE;
	}

	public void setCNE(String cIN) {
		CNE = cIN;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getFiliere() {
		return Filiere;
	}

	public void setFiliere(String filiere) {
		Filiere = filiere;
	}

	@Override
	public String toString() {
		return "Etudiant [CIN=" + CNE + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Filiere=" + Filiere + "]";
	}
	
	

}
