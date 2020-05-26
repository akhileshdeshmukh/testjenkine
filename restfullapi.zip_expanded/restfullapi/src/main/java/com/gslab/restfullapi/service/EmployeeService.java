package com.gslab.restfullapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gslab.restfullapi.pojo.employees;


public interface EmployeeService {

	public List<employees> getEmployeesByCompanyId(int cid);
	public employees findEmployeeByIdOfSelectedCompany(int cid,int eid);
	public employees findEmployeeByNameOfSelectedCompany(int cid,String name);
}
