package com.pg.filetracking.login;


import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Autowired
	RestTemplate restTemplate;
	
	private HttpHeaders getHeaders(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		return headers;
	}

    @Override
    public void save(Login login) {
    	login.setPassword(bCryptPasswordEncoder.encode(login.getPassword()));
        HashSet<Role> test=new HashSet<Role>();
        test.add(roleRepository.findAll().get(0));
        login.setRoles(test);
        loginRepository.save(login);
    }

    @Override
    public Login findByUsername(String loginName) {
    	  //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
          //String password = request.getParameter("password");
    	
          Login login=loginRepository.findByUsername(loginName);
          //login.setPassword(password);
        return login;
    }
    
    
}
