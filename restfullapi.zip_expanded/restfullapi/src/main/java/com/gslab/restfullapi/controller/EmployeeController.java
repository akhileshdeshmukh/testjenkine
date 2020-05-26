package com.gslab.restfullapi.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.restfullapi.pojo.employees;
import com.gslab.restfullapi.service.EmployeeService;
import com.gslab.restfullapi.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/v1/companies")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceobj;
	
	@GetMapping("/{cid}/employees")
	public List<employees> getAllEmployeesOfCompany(@PathVariable int cid)
	{
		 List<employees> emps=employeeServiceobj.getEmployeesByCompanyId(cid);
        for (employees emp : emps) {
			System.out.println(emp);
		}
        return emps;
	}
	
	@GetMapping("/{cid}/employees/{eid}")
	public employees findEmployeesOfCompany(@PathVariable int cid,@PathVariable int eid)
	{
		return employeeServiceobj.findEmployeeByIdOfSelectedCompany(cid, eid);
        
	}

	@GetMapping("/{id}/employee")
	public ResponseEntity<employees> findEmployeesByNameOfCompany(@PathVariable int id,@QueryParam("name") String name)
	{
		return new ResponseEntity<employees>(employeeServiceobj.findEmployeeByNameOfSelectedCompany(id, name), HttpStatus.OK); 
	}
}
