package com.bll.servicesimplementation;

import com.bll.services.IEtudiantManager;
import com.dao.hibernate.implementation.DaoEtudiantImplementation;
import com.project.data.Etudiant;

public class EtudiantService implements IEtudiantManager {

	
	DaoEtudiantImplementation etudiantService = new DaoEtudiantImplementation();
	
	public boolean addNewStudent(Etudiant etd) {
		etudiantService.add(etd);
		return true;
	}

}
