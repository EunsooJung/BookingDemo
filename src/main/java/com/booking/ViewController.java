/**
 * 
 */
package com.booking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author EUNSOO
 *
 */
@Controller
public class ViewController {
	
	/* 
	Add to change mode option (Dependency Injection based on Property)
	@Value("${app-mode}")
	private String appMode;
	*/
	
	/*
	 * Dependency Injection based on Constructor
	 */
	private String appMode;
	
	@Autowired
	public ViewController(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("datetime", new Date());
		model.addAttribute("userName", "Michael Jung");
		
		// conditional logic value for the Thymeleaf
		// model.addAttribute("mode","production");
		
		// To change mode development or production
		model.addAttribute("mode",appMode);
		
		return "index";
	}
}
