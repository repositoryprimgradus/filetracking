package com.pg.filetracking.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	
	@Autowired
	RestTemplate restTemplate;
	 @Autowired
	LoginServiceImpl loginService;
	 
	 @Autowired
	 LoginRepository loginRepository;
	 
	 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,   HttpServletResponse response, Authentication authentication ) throws IOException  {
    	HttpSession ses = request.getSession();
    	
    	Login login=new Login();
    	login.setUsername(request.getParameter("username"));
    	login.setPassword(request.getParameter("password"));
    	String token =null;
    	
    	 try {
    	
   
   
     login=loginRepository.findByUsername(request.getParameter("username"));
     ses.setAttribute("loginId", login.getLoginId());
     ses.setAttribute("Username",request.getParameter("username"));

      
     }catch (Exception e) {
    	e.printStackTrace();
    	
     }
    	 
    	 
    	 response.sendRedirect("/welcome");	 
     
   }
    
    
    
    

}
