package com.gslab.restfullapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.restfullapi.dao.companiedao;
import com.gslab.restfullapi.pojo.Companies;

@Service
public class companiesService implements companiesServiceinfer {

	@Autowired
	private companiedao companiedaoobj;
	
	@Override
	public List<Companies> getAllCompanies()
	{
		return companiedaoobj.findAll();
	}

	@Override
	public String deleteCompaniesById(Integer id) {
		
		companiedaoobj.deleteById(id);
		return "record is deleted";
	}

	@Override
	public String insertCompany(Companies c) {
		companiedaoobj.save(c);
		return "companies is registerd";
		
	}

	@Override
	public String updateCompanyDetailes(Companies c, int id) {
		companiedaoobj.deleteById(id);
		companiedaoobj.save(c);
		return "detailes is updated";
	}

	@Override
	public Optional<Companies> getCompanyById(int id) {
		
		return companiedaoobj.findById(id);
	}

	
}
