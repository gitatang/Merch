package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Merch;
import com.service.MerchService;
@Controller
public class MerchController {
	@Autowired
	private MerchService service;
	
	@RequestMapping("ceshi")
	public String get (Integer eid, Model model,Merch merch){
		
		merch =service.get(eid);
		System.out.println(merch.getName());
		 model.addAttribute("merch",merch);
		
		return "index";
		
		
	}

}
