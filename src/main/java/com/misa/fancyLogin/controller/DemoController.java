package com.misa.fancyLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	// from jsp: <form action=”processForm” method=”GET”>
	// same as: @RequestMapping(path="/", method=RequestMethod.GET
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	@GetMapping("/systems")
	public String showAdmins() {
		return "systems";
	}
}
