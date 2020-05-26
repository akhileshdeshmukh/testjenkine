package com.gslab.restfullapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.restfullapi.pojo.Companies;
import com.gslab.restfullapi.pojo.employees;


public interface Employeedao{

	public List<employees> findAllEmployeeByCompanyId(Integer cid);
	public employees findEmployeeByIdOfSelectedCompany(int cid,int eid);
	public employees findEmployeeByNameOfSelectedCompany(int cid,String name);
}
