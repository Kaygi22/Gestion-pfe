package com.factory;


import com.bll.servicesimplementation.EtudiantService;
import com.dao.hibernate.implementation.DaoEtudiantImplementation;
import com.project.data.Etudiant;

public class App {

	public static void main(String[] args) {

		Etudiant etd = new Etudiant("X09", "El Mehdi", "El Khayati", "GI");
		EtudiantService etudiantService = new EtudiantService();
		//etudiantService.addNewStudent(etd);
		
		System.out.println(new DaoEtudiantImplementation().getAll().toString());



	}

}
