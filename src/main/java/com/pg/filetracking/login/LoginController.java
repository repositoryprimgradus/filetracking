package com.pg.filetracking.login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class LoginController {
	
    @Autowired
	LoginServiceImpl loginService;

  
    
	
    

	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout,HttpServletRequest req,HttpSession ses,HttpServletResponse response) {
	 
	    	if (error != null) 
	            model.addAttribute("error", "Your username and password is invalid.");

	    	 if (logout != null)
	             model.addAttribute("message", "You have been logged out successfully.");

	        
	    	
	    
	        return "login";
	    }

    
  
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model,HttpServletRequest req,HttpSession ses) throws Exception {
		
    	
    	return "home";
    }
    
    
    
   
    
    @RequestMapping(value = "MainDashBoard.htm", method = RequestMethod.GET)
    public String MainDashBoard(HttpServletRequest req,HttpSession ses) throws Exception {
   
    	;
    	
      try {
     
   
     }catch (Exception e) {
    	
    	
     }
     
     return "MainDashBoard";
    }
    
    
    
    @RequestMapping(value = {"/sessionExpired","/invalidSession"}, method = RequestMethod.GET)
    public String sessionExpired(Model model,HttpServletRequest req,HttpSession ses) {
    	
    	try {
      	 
      	}
      	catch (Exception e) {
				e.printStackTrace();
			}
    	
        return "SessionExp";
    }
    
    @RequestMapping(value = {"/accessdenied"}, method = RequestMethod.GET)
    public String accessdenied(Model model,HttpServletRequest req,HttpSession ses) {
    	
        return "accessdenied";
    }
    
   
    
}
