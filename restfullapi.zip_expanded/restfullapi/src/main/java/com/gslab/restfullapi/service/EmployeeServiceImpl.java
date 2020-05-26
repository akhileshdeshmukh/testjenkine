package com.gslab.restfullapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.restfullapi.dao.Employeedao;
import com.gslab.restfullapi.pojo.employees;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private Employeedao employeedaoobj;
	
	
	@Override
	public List<employees> getEmployeesByCompanyId(int cid)
	{
		return employeedaoobj.findAllEmployeeByCompanyId(cid);
	}


	@Override
	public employees findEmployeeByIdOfSelectedCompany(int cid, int eid) {
		
		return employeedaoobj.findEmployeeByIdOfSelectedCompany(cid, eid);
	}


	@Override
	public employees findEmployeeByNameOfSelectedCompany(int cid, String name) {
		
	 return employeedaoobj.findEmployeeByNameOfSelectedCompany(cid, name);
	}
	
}
