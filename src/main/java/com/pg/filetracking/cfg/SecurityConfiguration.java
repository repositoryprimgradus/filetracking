package com.pg.filetracking.cfg;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.pg.filetracking.login.CustomLogoutHandler;
import com.pg.filetracking.login.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	 @Autowired
     private LoginSuccessHandler successHandler;
	
	 
	 
	 
	 
	 
	 
	 @Override
	 @Bean
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	     return super.authenticationManagerBean();
	 }
	 
	 
	 
	 
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}
	
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
		
	
		  .antMatchers("/resources/**", "/webjars/**","/assets/**","/static/assets/**").permitAll()
		  .antMatchers("/").hasRole("USER")
		  .antMatchers("/static/assets/css/**").permitAll()
		  .antMatchers("/static/assets/js/**").permitAll()
		  .antMatchers("/resources/**").permitAll()
		  .antMatchers("/api/v1/getBarcode4j").permitAll()
		  
		  .anyRequest().authenticated()
		  
		  .and()
		    .formLogin().loginPage("/login").defaultSuccessUrl("/welcome").failureUrl("/login?error").permitAll()
		    .usernameParameter("username").passwordParameter("password").successHandler(successHandler)
		  .and()
		    .logout().logoutSuccessUrl("/login?logout").addLogoutHandler(logoutSuccessHandler())
		   
		   .and()
		   .exceptionHandling().accessDeniedPage("/accessdenied")
		 
		    
		    .and()
		    
		    
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).invalidSessionUrl("/login").maximumSessions(1);
		 // http.csrf().disable();
		    
		    
		    
		   
		    
		  
		 
	}
	 
	
	
	
	@Bean
	public AccessDecisionManager  adm() {
		List<AccessDecisionVoter<? extends Object>> DecisionVoter= Arrays.asList(new RoleVoter(),new AuthenticatedVoter(),new WebExpressionVoter(),new RealTimeLockVoter());
		
	return  new UnanimousBased(DecisionVoter);
	}
	
	

	
	class RealTimeLockVoter implements AccessDecisionVoter<Object>{

		@Override
		public boolean supports(ConfigAttribute attribute) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean supports(Class<?> clazz) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
	
			

			 String url;
			 String Method=((FilterInvocation) object).getRequest().getMethod(); 
		    if(Method.equalsIgnoreCase("GET")) {
			 
			 String fullurl = ((FilterInvocation) object).getRequestUrl();
		        int firstQuestionMarkIndex = fullurl.indexOf("?");
		        
		        if (firstQuestionMarkIndex != -1) {
		        	url=fullurl.substring(0, firstQuestionMarkIndex);
		        }else {
		        	url=fullurl;
		        }
		        try {
		        url=url.split("/")[1];
		        }catch (Exception e) {
			
				}
		        
		      
		     

		     if(url.equalsIgnoreCase("DemandInitiationList.htm")) {
		    	 return ACCESS_GRANTED;
		     }
		    }
			
			return ACCESS_GRANTED;
		}
		
	}
	
	
	
	
	
	
	
	 
		public PasswordEncoder passwordencoder(){
	     return new BCryptPasswordEncoder();
	    }
		
			
		
		
		@Bean
		public LogoutHandler  logoutSuccessHandler() {
		return  new CustomLogoutHandler();
		}
		
	
		
		
		
}
