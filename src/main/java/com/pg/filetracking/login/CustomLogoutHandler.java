package com.pg.filetracking.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler  implements LogoutHandler  {

	//@Autowired
	//RfpMainService rfpmainservice;
	
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		 HttpSession ses=request.getSession();
		 try {
       	  //String LogId = ((Long) ses.getAttribute("LoginId")).toString();
       	  //rfpmainservice.LoginStampingUpdate(LogId, "L");
       	}
       	catch (Exception e) {
				e.printStackTrace();
			}	
	}
	
	
}
