package com.onb.employeereg.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onb.employeereg.domain.Employee;
import com.onb.employeereg.service.BranchService;
import com.onb.employeereg.service.DepartmentService;
import com.onb.employeereg.service.EmployeeService;
import com.onb.employeereg.service.SalaryConfigService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "employeeService")
	@Autowired
	private EmployeeService employeeService;
	@Resource(name = "branchService")
	@Autowired
	private BranchService branchService;
	@Resource(name = "departmentService")
	@Autowired
	private DepartmentService departmentService;
	@Resource(name = "salaryConfigService")
	@Autowired
	private SalaryConfigService salaryConfigService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to show add page");

		model.addAttribute("employeeAttribute", new Employee());
		model.addAttribute("id", id);

		return "eaddpage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("employeeAttribute") Employee employee) {
		logger.debug("Received request to add new employee");

		employeeService.add(employee);

		return "eaddedpage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "id", required = true) Integer id, Model model) {

		logger.debug("Received request to delete existing employee");

		employeeService.delete(id);

		model.addAttribute("id", id);

		return "edeletedpage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to show edit page");

		model.addAttribute("employeeAttribute", employeeService.get(id));

		return "eeditpage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEdit(
			@ModelAttribute("employeeAttribute") Employee employee,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to update employee");

		employee.setId(id);

		employeeService.edit(employee);

		model.addAttribute("id", id);

		return "eeditedpage";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String getView(
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to show edit page");

		model.addAttribute("employeeAttribute", employeeService.get(id));

		model.addAttribute("salaryAttribute", salaryConfigService.get(0));

		Employee emp = employeeService.get(id);
		Integer departmentId = emp.getDepartmentId();

		model.addAttribute("departmentAttribute",
				departmentService.get(departmentId));

		return "eemployeeprofile";
	}

}
