package com.gslab.restfullapi.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.boot.actuate.endpoint.jmx.annotation.EndpointJmxExtension;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Companies {

	int CompanyId;
	String CompanyName;
	//@JsonIgnore
	private List<employees> employees=new ArrayList<employees>();
	
	public Companies() {
	}
	
	public Companies(int companyId, String companyName) {
		super();
		CompanyId = companyId;
		CompanyName = companyName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	
	@Column(length = 100)
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	
	
	  @OneToMany(mappedBy = "companies", cascade = CascadeType.ALL, orphanRemoval=
	  true) public List<employees> getEmployees() { return employees; }
	  
	  public void setEmployees(List<employees> employees) { this.employees =
	  employees; }
	 

	@Override
	public String toString() {
		return "Companies [CompanyId=" + CompanyId + ", CompanyName=" + CompanyName + "]";
	}
	
	
	
}
