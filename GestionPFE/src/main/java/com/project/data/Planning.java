package com.project.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planning")
public class Planning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planning")
	private Integer id_plan;

	@Column(name = "date")
	private String date;

	@OneToOne
	@JoinColumn(name = "id_pfe")
	private PFE pfe;

	@OneToOne
	@JoinColumn(name = "cne_etudiant")
	private Etudiant etudiant;

	public Planning() {
	}

	public Planning(PFE pfe, String date, Etudiant etudiant) {
		super();
		this.date = date;
		this.pfe = pfe;
		this.etudiant = etudiant;
	}

	public int getId_plan() {
		return id_plan;
	}

	public void setId_plan(int id_plan) {
		this.id_plan = id_plan;
	}

	public PFE getPfe() {
		return pfe;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPfe(PFE pfe) {
		this.pfe = pfe;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public void setId_plan(Integer id_plan) {
		this.id_plan = id_plan;
	}

}
