package com.coffee.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coffee.springweb.domain.Admin;
import com.coffee.springweb.service.AdminService;

import org.springframework.ui.Model;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado){
		Admin admin = new Admin();
		
		model.addAttribute("resultado", resultado);
		model.addAttribute("adminDTO", admin);
		
		return "admin";
	}

	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handlerAdmin(@ModelAttribute("adminDTO") Admin admin, 
			Model model, 
			RedirectAttributes ra){
		String message = "";
		
		if(adminService.saveAdmin(admin)){
			message = "Se realizo con Éxito el guardado del Administrador!";
		}else{
			message = "Ocurrio un error y no se pudo guarar con éxito el Administrador!!!";
		}
		
		ra.addFlashAttribute("resultado", message);
		ra.addFlashAttribute("admins", adminService.findAllAdmins());
		
		return "redirect:/admins";
	}
	
	
	@RequestMapping("/admins")
	public String showAdmins(Model model, @ModelAttribute("admins")List<Admin> admins){
		if(admins != null){
			model.addAttribute("admins", admins);
		}else{
			model.addAttribute("admins", adminService.findAllAdmins());
		}
		
		return "admins";
	}
}
