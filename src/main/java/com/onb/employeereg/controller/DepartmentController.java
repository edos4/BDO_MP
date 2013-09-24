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
import com.onb.employeereg.domain.Department;
import com.onb.employeereg.service.DepartmentService;


/**
 * Handles and retrieves branch request
 */
@Controller
@RequestMapping("/departments")
public class DepartmentController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(@RequestParam(value="id", required=true) Integer id, Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Department and add to model
    	// This is the formBackingOBject
    	model.addAttribute("departmentAttribute", new Department());
    	model.addAttribute("id", id);

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "departments/addpage";
	}
 
    /**
     * Adds a new department by delegating the processing to DepartmentDAO.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("departmentAttribute") Department department) {
		logger.debug("Received request to add new department");
		
    	// The "departmentAttribute" model has been passed to the controller from the JSP
    	// We use the name "departmentAttribute" because the JSP uses that name
		
		// Call BranchDAO to do the actual adding

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "departments/addedpage";
	}
    
    /**
     * Deletes an existing department by delegating the processing to BranchDAO.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing department");
		
		// Call DepartmentDAO to do the actual deleting
		departmentService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "departments/deletedpage";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Branch and add to model
    	// This is the formBackingOBject
    	model.addAttribute("departmentAttribute", departmentService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "departments/editpage";
	}
    
    /**
     * Edits an existing branch by delegating the processing to DepartmentDAO.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("departmentAttribute") Department department, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update department");
    	
    	department.setId(id);
    	
    	// Delegate to BranchDAO for editing
    	departmentService.edit(department);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "departments/editedpage";
	}
    
    @RequestMapping(value = "/departments/view", method = RequestMethod.GET)
    public String getView(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Branch and add to model
    	// This is the formBackingOBject
    	model.addAttribute("departmentAttribute", departmentService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "departments/branchprofile";
	}
    
}
