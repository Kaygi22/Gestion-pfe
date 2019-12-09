package com.gestionpfe.service;

import java.util.List;

import com.project.data.Prof;


public interface IProfService {
	public void addProf(Prof prof);
	public void deleteProf(int id_prof);
	public void updateProf(int id_prof, Prof newProf);
	public Prof getProfById(int id_prof);
	public List<Prof> getAllProfs();

}
