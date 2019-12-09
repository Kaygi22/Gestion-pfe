package com.projet.jee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.hibernate.implementation.DaoProfImplementation;
import com.project.data.Prof;

@Controller
@RequestMapping("/Prof")
public class ProfController {
	
	//DAO
	DaoProfImplementation profDAO = new DaoProfImplementation();


	@RequestMapping("/ajouter")
	public String add(Model model) {
		model.addAttribute("Prof", new Prof());
		return "dev_Prof/add";
	}
	
	@RequestMapping("/submitAddingProf")
	public String submitAdding(@ModelAttribute("Prof") Prof prof) {
		System.out.println(prof.toString());
		profDAO.add(prof);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String liste(Model model) {
		List<Prof> listProf = new ArrayList<Prof>();
		listProf = profDAO.getAll();
		model.addAttribute("profs", listProf);
		return "dev_Prof/list";
	}
	
	@RequestMapping(value="/delete_prof", method=RequestMethod.GET)
	public String deleteStudent(Model model, HttpServletRequest request) {
		Integer code_prof = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID PROF: "+code_prof);
		profDAO.delete(code_prof);
		return "redirect:list";
	}
	
	@RequestMapping(value="/edit_prof", method=RequestMethod.GET)
	public String editStudent(Model model, HttpServletRequest request) {
		Integer code_prof = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID PROF: "+code_prof);
		return "dev_Etudiant/edit";
	}
	
}
