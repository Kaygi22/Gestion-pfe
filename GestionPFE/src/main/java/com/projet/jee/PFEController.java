package com.projet.jee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.hibernate.implementation.DaoPfeImplementation;
import com.dao.hibernate.implementation.DaoProfImplementation;
import com.project.data.PFE;
import com.project.data.Prof;

@Controller
@RequestMapping("/PFE")
public class PFEController {
	
	DaoProfImplementation profDao = new DaoProfImplementation();
	DaoPfeImplementation daoPFE = new DaoPfeImplementation();
	
	@RequestMapping("/ajouter")
	public String add(Model model) {
		List<Prof> profs = new ArrayList<Prof>();
		profs = profDao.getAll();
		model.addAttribute("pfe", new PFE());
		model.addAttribute("profs", profs);
		return "dev_PFE/add";
	}
	
	@RequestMapping("/submitAddingPFE")
	public String submitAdding(HttpServletRequest request, Model model) {
		
		//System.out.println(PFE.toString());
		System.out.println("Sujet: " + request.getParameter("sujet"));
		String[] encadrants = request.getParameterValues("encadrant");
		String[] juries = request.getParameterValues("jury");
		System.out.println("Encadrants: " + Arrays.toString(encadrants));
		System.out.println("Juries: " + Arrays.toString(juries));
		
		Set<Prof> listeDesProfs = new HashSet<Prof>();
		Set<Prof> listeDesJury = new HashSet<Prof>();

		Prof loopingProf;
		for (int i = 0; i < encadrants.length; i++) {
			Integer prof_code = Integer.parseInt(encadrants[i]);
			loopingProf = profDao.getById(prof_code);
			listeDesProfs.add(loopingProf);
		}
		
		for (int i = 0; i < juries.length; i++) {
			Integer prof_code = Integer.parseInt(juries[i]);
			loopingProf = profDao.getById(prof_code);
			listeDesJury.add(loopingProf);
		}
		
		System.out.println();
		
		PFE pfeToInsert = new PFE(request.getParameter("sujet"), listeDesProfs, listeDesJury);
		daoPFE.add(pfeToInsert);
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	@Transactional
	public String list(Model model) {
		List<PFE> pfes = new ArrayList<PFE>();
		pfes = daoPFE.getAll();
		System.out.println(pfes.toString());
		model.addAttribute("pfes", pfes);
		return "dev_PFE/list";
	}
	
	@RequestMapping(value="/delete_PFE", method=RequestMethod.GET)
	public String deletePfe(Model model, HttpServletRequest request) {
		String idPfe = request.getParameter("id_pfe");
		daoPFE.delete(Integer.parseInt(idPfe));
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete_encadrant", method=RequestMethod.GET)
	public String removeEncadrant(Model model, HttpServletRequest request){
		String idPfe = request.getParameter("id_pfe");
		String idProfToRemove = request.getParameter("id_prof");
		System.out.println("Id pfe: " + idPfe);
		System.out.println("Id prof: " + idProfToRemove);
		Prof profToRemove = profDao.getById(Integer.parseInt(idProfToRemove));
		PFE currPfe = daoPFE.getById(Integer.parseInt(idPfe));
		
		currPfe.removeEncadrant(profToRemove);
		System.out.println("NEW PFE: " + currPfe.toString());
		daoPFE.update(currPfe);
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete_jury", method=RequestMethod.GET)
	public String removeJury(Model model, HttpServletRequest request){
		String idPfe = request.getParameter("id_pfe");
		String idProfToRemove = request.getParameter("id_jury");
		System.out.println("Id pfe: " + idPfe);
		System.out.println("Id jury: " + idProfToRemove);
		Prof profToRemove = profDao.getById(Integer.parseInt(idProfToRemove));
		PFE currPfe = daoPFE.getById(Integer.parseInt(idPfe));
		
		currPfe.removeJury(profToRemove);
		System.out.println("NEW PFE: " + currPfe.toString());
		daoPFE.update(currPfe);
		return "redirect:list";
	}

}
