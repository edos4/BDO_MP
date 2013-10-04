package com.onb.employeereg.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onb.employeereg.domain.SalaryConfig;
import com.onb.employeereg.service.SalaryConfigService;

@Controller
@RequestMapping("/")
public class SettingsController {

	protected Logger logger = Logger.getLogger("controller");

	@Resource(name = "salaryConfigService")
	@Autowired
	private SalaryConfigService salaryConfigService;

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String getEdit(Model model) {
		logger.debug("Received request to show edit page");

		model.addAttribute("settingsAttribute", salaryConfigService.get(0));

		return "seditpage";
	}

	@RequestMapping(value = "/settings/edit", method = RequestMethod.POST)
	public String saveEdit(
			@ModelAttribute("salaryAttribute") SalaryConfig salaryConfig,
			Model model) {
		logger.debug("Received request to update salary config");

		salaryConfig.setId(0);

		salaryConfigService.edit(salaryConfig);

		model.addAttribute("id", 0);

		return "seditedpage";
	}

}
