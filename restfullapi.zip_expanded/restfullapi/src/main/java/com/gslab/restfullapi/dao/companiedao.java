
package com.gslab.restfullapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.restfullapi.pojo.Companies;

@Repository
public interface companiedao extends JpaRepository<Companies, Integer>{

}
