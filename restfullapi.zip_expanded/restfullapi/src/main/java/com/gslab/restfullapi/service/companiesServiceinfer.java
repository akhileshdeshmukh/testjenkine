package com.gslab.restfullapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gslab.restfullapi.pojo.Companies;


public interface companiesServiceinfer {
	
	public List<Companies> getAllCompanies();
	public String deleteCompaniesById(Integer id);
	public String insertCompany(Companies c);
	public String updateCompanyDetailes(Companies c,int id);
	public Optional<Companies> getCompanyById(int id);

}
