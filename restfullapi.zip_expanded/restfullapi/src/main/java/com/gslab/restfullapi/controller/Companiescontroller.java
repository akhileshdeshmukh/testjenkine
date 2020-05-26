package com.gslab.restfullapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.restfullapi.pojo.Companies;
import com.gslab.restfullapi.service.companiesService;
import com.gslab.restfullapi.service.companiesServiceinfer;

@RestController
@RequestMapping("/v1")
public class Companiescontroller {
	
	@Autowired
	private companiesService companiesServiceObj;
	
	@GetMapping("/companies")
	public List<Companies> getAllCompanies()
	{
		return companiesServiceObj.getAllCompanies();
	}
	
	
	@PostMapping("/companies")
	public String addCompany(@RequestBody Companies c)
	{
		return companiesServiceObj.insertCompany(c);
	}
	
	@PutMapping("companies/{id}")
	public String updateCompany(@RequestBody Companies c,@PathVariable int id)
	{
		return companiesServiceObj.updateCompanyDetailes(c, id);
	}
	
	@GetMapping("companies/{id}")
	public Optional<Companies> updateCompany(@PathVariable int id)
	{
		return companiesServiceObj.getCompanyById(id);
	}
	
	@DeleteMapping("companies/{id}")
	public String deteleCompanies(@PathVariable int id)
	{
		return companiesServiceObj.deleteCompaniesById(id);
	}

}
