package com.projet.jee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bll.servicesimplementation.EtudiantService;
import com.dao.hibernate.implementation.DaoEtudiantImplementation;
import com.dao.hibernate.implementation.DaoProfImplementation;
import com.project.data.Etudiant;

@Controller
@RequestMapping("/Etudiant")
public class EtudiantController {
	
	// Services
	EtudiantService etudiantService = new EtudiantService();
	
	// DAO implementations
	DaoEtudiantImplementation etudiantDAO = new DaoEtudiantImplementation();
	
	public  EtudiantController() {
		System.out.println("Controller instanciated");
	}
	
	@RequestMapping("/ajouter")
	public String add(Model model) {
		model.addAttribute("Etudiant" ,new Etudiant());
		return "dev_Etudiant/add";
	}
	
	@RequestMapping("/submitAdding")
	public String submitAdding(@ModelAttribute("Etudiant") Etudiant student) {
		System.out.println(student.toString());
		etudiantService.addNewStudent(student);
		return "redirect:liste";
	}
	
	@RequestMapping("/liste")
	public String listEtudiants(Model model) {
		List<Etudiant> list = new ArrayList<Etudiant>();
		list = etudiantDAO.getAll(); 
		model.addAttribute("listEtudiants" ,list);
		return "dev_Etudiant/list";
	}
	
	@RequestMapping(value="/delete_student", method=RequestMethod.GET)
	public String deleteStudent(Model model, HttpServletRequest request) {
		String CNE_Student = request.getParameter("id");
		System.out.println("ID Student: "+CNE_Student);
		etudiantDAO.delete(CNE_Student);
		return "redirect:liste";
	}
	
	@RequestMapping(value="/edit_student", method=RequestMethod.GET)
	public String editStudent(Model model, HttpServletRequest request) {
		String CNE_Student = request.getParameter("id");
		System.out.println("ID Student: "+CNE_Student);
		return "dev_Etudiant/edit";
	}

}
