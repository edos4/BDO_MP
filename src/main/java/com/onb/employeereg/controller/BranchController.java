package com.onb.employeereg.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onb.employeereg.domain.Branch;
import com.onb.employeereg.service.BranchService;
import com.onb.employeereg.service.DepartmentService;
import com.onb.employeereg.service.EmployeeService;

@Controller
@RequestMapping("/")
public class BranchController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="branchService")
	private BranchService branchService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public String getBranches(Model model) {
    	
    	logger.debug("Received request to show all branches");
    	
    	List<Branch> branches = branchService.getAll();
    	
    	model.addAttribute("branches", branches);
    	
    	return "branches/branchespage";
	}
    

    @RequestMapping(value = "/branches/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	model.addAttribute("branchAttribute", new Branch());

    	return "branches/addpage";
	}

    @RequestMapping(value = "/branches/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("branchAttribute") Branch branch) {
		logger.debug("Received request to add new branch");
		
  
		branchService.add(branch);

    	
		return "branches/addedpage";
	}
 
    @RequestMapping(value = "/branches/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing branch");
		
		branchService.delete(id);
		
		model.addAttribute("id", id);
    	
    	return "branches/deletedpage";
	}
    
    @RequestMapping(value = "/branches/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	model.addAttribute("branchAttribute", branchService.get(id));
    	
    	return "branches/editpage";
	}
  
    @RequestMapping(value = "/branches/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("branchAttribute") Branch branch, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update branch");
    
    	branch.setId(id);
    	
    	branchService.edit(branch);
    	
    	model.addAttribute("id", id);
		
    	return "branches/editedpage";
	}
    
    @RequestMapping(value = "/branches/view", method = RequestMethod.GET)
    public String getView(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	model.addAttribute("branchAttribute", branchService.get(id));
    	model.addAttribute("departments", departmentService.getAll(id));
    	return "branches/branchprofile";
	}
    
}
