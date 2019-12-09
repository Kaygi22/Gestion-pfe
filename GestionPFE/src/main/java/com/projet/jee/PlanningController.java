package com.projet.jee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.hibernate.implementation.DaoEtudiantImplementation;
import com.dao.hibernate.implementation.DaoPfeImplementation;
import com.dao.hibernate.implementation.DaoPlanningImplementation;
import com.project.data.Etudiant;
import com.project.data.PFE;
import com.project.data.Planning;
import com.project.data.Prof;

@Controller
@RequestMapping("Planning")
public class PlanningController {
	
	//DAO
	DaoPfeImplementation pfeDao = new DaoPfeImplementation();
	DaoEtudiantImplementation etudiantDao = new DaoEtudiantImplementation();
	DaoPlanningImplementation planningDao = new DaoPlanningImplementation();

	@RequestMapping("/ajouter")
	public String add(Model model) {
		model.addAttribute("planning", new Planning());
		List<PFE> listDesPfes = pfeDao.getAll();
		List<Etudiant> listeDesEtudiants = etudiantDao.getAll();
		model.addAttribute("etudiants", listeDesEtudiants);
		model.addAttribute("pfes", listDesPfes);
		return "dev_Planning/add";
	}
	
	@RequestMapping("/submitAddingPlanning")
	public String submitAdding(HttpServletRequest request, Model model) {
		
		Planning planning;
		
		String date = request.getParameter("date");
		String id_pfe = request.getParameter("id_pfe");
		String id_etudiant = request.getParameter("id_etudiant");
		
		PFE pfe = pfeDao.getById(Integer.parseInt(id_pfe));
		Etudiant etudiant = etudiantDao.getById(id_etudiant);
		
		planning = new Planning(pfe, date, etudiant);
		System.out.println("Planning to add: " + planning.toString());
		planningDao.add(planning);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<Planning> listPlanning = planningDao.getAll();
		System.out.println(listPlanning.toString());
		model.addAttribute("plannings", listPlanning);
		return "dev_Planning/list";
	}
	
	@RequestMapping(value = "/delete_planning", method=RequestMethod.GET)
	public String removePlanning(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		planningDao.delete(Integer.parseInt(id));
		return "redirect:list";
	}
}
