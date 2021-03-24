package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller2 {
	
	@RequestMapping("/hello2")
	
	public String disply() {
		return "ViewPage2";
	}
	
	@RequestMapping("/show")
	public ModelAndView show() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("key2", "Hello HP laptop");
//		modelAndView.setViewName("ShowData");
//		return modelAndView;
		
//	 in	single return both view nd model 
		String name="Hello HP laptop";
		return new ModelAndView("ShowData","key2",name);
	}
	

}
