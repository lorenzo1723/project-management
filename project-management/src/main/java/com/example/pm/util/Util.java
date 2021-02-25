package com.example.pm.util;

import org.springframework.ui.Model;

public class Util {
	
	public static void setPageTitle(Model model, String title) {
		model.addAttribute("title", title);
	}
}
