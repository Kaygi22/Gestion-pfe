package com.dao.hibernate.implementation;

import com.dao.hibernate.GenericDaoImplementation;
import com.project.data.Etudiant;

public class DaoEtudiantImplementation extends GenericDaoImplementation<Etudiant, String> {

	public DaoEtudiantImplementation() {
		super(Etudiant.class);
	}

}
