package com.gestionpfe.service;

import java.util.List;

import com.project.data.Etudiant;


public interface IEtudiantService {
	
	public void addEtudiant(Etudiant etudiant);
	public void deleteEtudiant(int cne);
	public void updateEtudiant(int cne, Etudiant newEtudiant);
	public Etudiant getEtudiantById(int cne);
	public List<Etudiant> getAllEtudiants();

}
