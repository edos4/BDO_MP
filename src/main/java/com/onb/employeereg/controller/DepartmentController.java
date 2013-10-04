package com.onb.employeereg.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onb.employeereg.domain.Branch;
import com.onb.employeereg.domain.Department;
import com.onb.employeereg.service.BranchService;
import com.onb.employeereg.service.DepartmentService;
import com.onb.employeereg.service.EmployeeService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="branchService")
	private BranchService branchService;
	@Resource(name="employeeService")
	private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(@RequestParam(value="id", required=true) Integer id, Model model) {
    	logger.debug("Received request to show add page");

    	model.addAttribute("departmentAttribute", new Department());
    	model.addAttribute("id", id);

    	return "daddpage";
	}
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("departmentAttribute") Department department) {
		logger.debug("Received request to add new department");
		
		departmentService.add(department);
		
		return "daddedpage";
	}

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing department");
		
		departmentService.delete(id);
		
		model.addAttribute("id", id);
    	
		return "ddeletedpage";
	}

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	model.addAttribute("departmentAttribute", departmentService.get(id));
    	
    	return "deditpage";
	}
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("departmentAttribute") Department department, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update department");
    	
    	department.setId(id);
    	
    	departmentService.edit(department);
    	
		model.addAttribute("id", id);
		
		return "deditedpage";
	}
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getView(@RequestParam(value="id", required=true) Integer id, 
    					   @RequestParam(value="bid", required=true) Integer bid, 
    										Model model) {
    	logger.debug("Received request to show edit page");
        
    	model.addAttribute("departmentAttribute", departmentService.get(id));
    	model.addAttribute("employees", employeeService.getAll(id));
    	model.addAttribute("branchAttribute", branchService.get(bid));
    	
    	return "ddepartmentprofile";
	}
}
