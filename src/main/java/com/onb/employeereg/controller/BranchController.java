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


/**
 * Handles and retrieves branch request
 */
@Controller
@RequestMapping("/")
public class BranchController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="branchService")
	private BranchService branchService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	/**
	 * Handles and retrieves all branches and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public String getBranches(Model model) {
    	
    	logger.debug("Received request to show all branches");
    	
    	// Retrieve all branches by delegating the call to BranchDAO
    	List<Branch> branches = branchService.getAll();
    	
    	// Attach branches to the Model
    	model.addAttribute("branches", branches);
    	
    	// This will resolve to /WEB-INF/jsp/branchespage.jsp
    	return "branches/branchespage";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/branches/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Branch and add to model
    	// This is the formBackingOBject
    	model.addAttribute("branchAttribute", new Branch());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "branches/addpage";
	}
 
    /**
     * Adds a new branch by delegating the processing to BranchDAO.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/branches/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("branchAttribute") Branch branch) {
		logger.debug("Received request to add new branch");
		
    	// The "branchAttribute" model has been passed to the controller from the JSP
    	// We use the name "branchAttribute" because the JSP uses that name
		
		// Call BranchDAO to do the actual adding
		branchService.add(branch);

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "branches/addedpage";
	}
    
    /**
     * Deletes an existing branch by delegating the processing to BranchDAO.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/branches/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing branch");
		
		// Call BranchDAO to do the actual deleting
		branchService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "branches/deletedpage";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/branches/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Branch and add to model
    	// This is the formBackingOBject
    	model.addAttribute("branchAttribute", branchService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "branches/editpage";
	}
    
    /**
     * Edits an existing branch by delegating the processing to BranchDAO.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/branches/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("branchAttribute") Branch branch, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update branch");
    
    	// The "branchAttribute" model has been passed to the controller from the JSP
    	// We use the name "branchAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	branch.setId(id);
    	
    	// Delegate to BranchDAO for editing
    	branchService.edit(branch);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "branches/editedpage";
	}
    
    @RequestMapping(value = "/branches/view", method = RequestMethod.GET)
    public String getView(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Branch and add to model
    	// This is the formBackingOBject
    	model.addAttribute("branchAttribute", branchService.get(id));
    	model.addAttribute("departments", departmentService.getAll(id));
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "branches/branchprofile";
	}
    
}
