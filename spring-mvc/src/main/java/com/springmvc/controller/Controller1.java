package com.springmvc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
	
	@RequestMapping("/hello")
	public String show() {
		return "ViewPage";
	}
//System.out.println();
	
	@RequestMapping("/helloagain")
		public String result(Model model) {
		List<String> list=new ArrayList<String>();
		Collections.addAll(list, "amir khan","umar shaikh","arif naseem");
		model.addAttribute("key",list);
		
		return "final";
		
	}
}
