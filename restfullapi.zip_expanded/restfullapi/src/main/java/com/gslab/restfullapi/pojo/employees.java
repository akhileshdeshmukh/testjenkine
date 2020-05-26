package com.gslab.restfullapi.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="Employee")
@Data
public class employees implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String firstName;
	private String lastName;
	@ManyToOne
	@JoinColumn(name = "companyId")
	Companies companies=new Companies();

	public employees() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "employees [id=" + id + ", city=" + city + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	
	

}