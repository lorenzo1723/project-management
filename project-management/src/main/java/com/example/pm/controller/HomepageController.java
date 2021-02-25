package com.example.pm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pm.util.Util;

@Controller
public class HomepageController {
	
	@GetMapping
	public String displayHomepage(Model model) {
		Util.setPageTitle(model, "Homepage");
		return "main/homepage";
	}
}
