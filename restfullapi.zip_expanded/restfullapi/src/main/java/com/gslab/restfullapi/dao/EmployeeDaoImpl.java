package com.gslab.restfullapi.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gslab.restfullapi.pojo.employees;

@Repository
public class EmployeeDaoImpl implements Employeedao {

	@PersistenceUnit
	private EntityManagerFactory emf;


	@Override
	public List<employees> findAllEmployeeByCompanyId(Integer cid) {
		
		String jpql="select emp from employees emp join fetch emp.companies c where c.companyId=:id";
		//return sf.getCurrentSession().createQuery(jpql,employees.class).setParameter("id", cid).getResultList();		
	
		//String jpql="select e from employees e";
		//return sf.getCurrentSession().createQuery(jpql,employees.class).getResultList();		
		
		 EntityManager em = emf.createEntityManager();
	        List<employees> emps = em
	                .createQuery(jpql,employees.class).setParameter("id", cid)
	                .getResultList();
	        		
		return emps;
	}


	@Override
	public employees findEmployeeByIdOfSelectedCompany(int cid, int eid) {
		
		long id=eid;
		String jpql="select emp from employees emp join fetch emp.companies c where c.companyId=:cid and emp.id=:eid";
		
		EntityManager em = emf.createEntityManager();
		return  em
                .createQuery(jpql,employees.class).setParameter("cid", cid).setParameter("eid", id)
                .getSingleResult();
	}


	@Override
	public employees findEmployeeByNameOfSelectedCompany(int cid, String name) {
	
		String jpql="select emp from employees emp join fetch emp.companies c where c.companyId=:cid and emp.firstName=:name";
		
		EntityManager em = emf.createEntityManager();
		return  em
                .createQuery(jpql,employees.class).setParameter("cid", cid).setParameter("name", name)
                .getSingleResult();
	}
	
	
}
