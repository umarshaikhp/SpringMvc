package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.tags.EditorAwareTag;

import com.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired
	EmpDao dao;

	@RequestMapping("/empform")
	public String showform(Model m) {
		System.out.println("by");

		m.addAttribute("command",new Emp());
		return "empform";	
	}
	
	@RequestMapping(value ="/save" , method = RequestMethod.POST)
		public String save(@ModelAttribute("emp") Emp emp) {
		//System.out.println(emp.getDesignation());
		dao.save(emp);
			return "redirect:/viewemp";
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
	List<Emp> list = dao.getEmployees();
	m.addAttribute("list", list);
	return "viewemp";
	
	}	
	
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete (@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
	}
	
	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model model) {
		Emp emp = dao.getEmpById(id);
		model.addAttribute("command", emp);
		return "empeditform";
		
	}
	
	@RequestMapping(value = "/editsave" , method = RequestMethod.GET)
	public String editsave(@ModelAttribute("emp1") Emp emp1) {

		dao.update(emp1);
		return "redirect:/viewemp";
		
	}

}
