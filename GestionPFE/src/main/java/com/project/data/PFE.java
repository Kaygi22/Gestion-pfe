package com.project.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "pfe")
public class PFE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pfe")
	private Integer id_pfe;
	@Column(name = "sujet")
	private String sujet;

	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.MERGE, CascadeType.MERGE})
	@JoinTable(
			name = "pfe_encadrant",
			joinColumns = @JoinColumn(name = "pfe_id"), 
			inverseJoinColumns = @JoinColumn(name = "encadrant_id")
	)
	private Set<Prof> encadrants;

	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.MERGE, CascadeType.MERGE})
	@JoinTable(
			name = "pfe_jury",
			joinColumns = @JoinColumn(name = "pfe_id"), 
			inverseJoinColumns = @JoinColumn(name = "jury_id")
	)
	private Set<Prof> jury;

	
	public void addEncadrant(Prof encadrant) {

		if (this.encadrants == null) {
			encadrants = new HashSet<Prof>();
		}

		if (encadrant == null)
			return;

		this.encadrants.add(encadrant);

	}
	
	

	public void addJury(Prof jury) {
		if (this.jury == null)
			this.jury = new HashSet<Prof>();

		if (jury == null)
			return;
		
		this.jury.add(jury);

	}

	public void removeEncadrant(Prof encadrant) {
		if (this.encadrants == null) {
			System.out.println("encadrant est nulle");
			return;
		}
			

		if (encadrant == null) {
			System.out.println("encadrant entrée est nulle");
			return;
		}

		for (Iterator iterator = encadrants.iterator(); iterator.hasNext();) {
			Prof prof = (Prof) iterator.next();
			if(prof.getCode() == encadrant.getCode()) {
				iterator.remove();
			}
		}
		

	}
	
	public void removeJury(Prof jury) {
		if (this.jury == null)
			return;

		if (jury == null)
			return;

		for (Iterator iterator = this.jury.iterator(); iterator.hasNext();) {
			Prof prof = (Prof) iterator.next();
			if(prof.getCode() == jury.getCode()) {
				iterator.remove();
			}
		}
	}

	public Set<Prof> getEncadrants() {
		return encadrants;
	}

	public void setEncadrants(Set<Prof> encadrants) {
		this.encadrants = encadrants;
	}

	public void setId_pfe(Integer id_pfe) {
		this.id_pfe = id_pfe;
	}

	public Set<Prof> getJury() {
		return jury;
	}

	public void setJury(Set<Prof> jury) {
		this.jury = jury;
	}

	public PFE() {
	}

	public PFE(String sujet, Set<Prof> encadrant, Set<Prof> jury) {
		super();
		this.sujet = sujet;
		this.jury = jury;
		this.encadrants = encadrant;
		
		
		for (Iterator iterator = jury.iterator(); iterator.hasNext();) {
			Prof prof = (Prof) iterator.next();
			addJury(prof);
		}
		
		for (Iterator iterator = encadrant.iterator(); iterator.hasNext();) {
			Prof prof = (Prof) iterator.next();
			addEncadrant(prof);
		}

		
	}

	public int getId_pfe() {
		return id_pfe;
	}

	public void setId_pfe(int id_pfe) {
		this.id_pfe = id_pfe;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}



	@Override
	public String toString() {
		return "PFE [id_pfe=" + id_pfe + ", sujet=" + sujet + ", encadrants=" + encadrants.toString() + ", jury=" + jury.toString() + "]";
	}
	
	

}
