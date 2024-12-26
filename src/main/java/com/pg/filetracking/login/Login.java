package com.pg.filetracking.login;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "login")
public class Login {
	
    private Long LoginId;
    private String Username;
    private String Password;
    private String EmpId;
    private int IsActive;
    private String CreatedBy;
    private String CreatedDate;
    private String ModifiedBy;
    private String ModifiedDate;
    private Set<Role> roles;
 
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    
    public Long getLoginId() {
		return LoginId;
	}
	public void setLoginId(Long loginId) {
		LoginId = loginId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	@ManyToMany
    @JoinTable(name = "login_role_security", joinColumns = @JoinColumn(name = "LoginId"), inverseJoinColumns = @JoinColumn(name = "RoleId"))
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int isActive) {
		IsActive = isActive;
	}
	
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	
    
	
    
   
}
