package com.llce.gmis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gmis")
public class GmisController {

	@RequestMapping("/hello")
	public String hello(){
		return "index";
	}
	
}
