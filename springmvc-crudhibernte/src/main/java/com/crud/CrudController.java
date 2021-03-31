package com.crud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.StudentDao;
import com.model.Student;

@Controller
public class CrudController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping("/")
	public String addStudent(Model model) {
		model.addAttribute("title", "add product");
		return "add";
		
	}
	
	@RequestMapping("/success")
	public String home(Model model) {
		List<Student> allStudents = studentDao.getAllStudent();
		model.addAttribute("allStudent", allStudents);
		return "success";
		
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("title", "Add Product");
		return "add";
		
	}
	
	@RequestMapping(value = "/formHandle" , method = RequestMethod.POST)
	public RedirectView formHandle(@ModelAttribute("userModel") Student student, HttpServletRequest request) {
		System.out.println(student);
		studentDao.createStudent(student);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/");
		return redirectView;
		
	}
	
	@RequestMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id,HttpServletRequest request) {
		studentDao.delStudent(id);
		RedirectView redirectView = new RedirectView();
		// it is used to redirect success page with the help of request.getcontextpath
		redirectView.setUrl(request.getContextPath()+ "/success");
		return redirectView;
		
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id")int id,Model model) {
Student singleStudent = this.studentDao.getSingleStudent(id);
model.addAttribute("singleStudent", singleStudent);
		return "updatePage";
		
	}
	

}
