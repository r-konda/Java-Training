package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_Details")
public class EmployeeDetails implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	 @Column(name = "address_line")
	private String addressLine;
	 @Column(name = "city_name")
	private String cityName;
//	private Employee employee;
	
	
	public EmployeeDetails(long id, String addressLine, String cityName ) {
		super();
		this.id = id;
		this.addressLine = addressLine;
		this.cityName = cityName;
//		this.employee = employee;

	}

public EmployeeDetails() {
	// TODO Auto-generated constructor stub
}
	


//	public Employee getEmployee() {
//		return employee;
//	}
//
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAddressLine() {
		return addressLine;
	}


	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



}
