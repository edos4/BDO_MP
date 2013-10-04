package com.onb.employeereg.controller;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Home {

	protected Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEdit(Model model) {
		logger.debug("Received request to show home page");

		return "home";
	}

}
