package com.fg.curd.curd.entity;


import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="employee")
@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank(message="Name field can't be blank")
	@NotEmpty(message="Please enter your name")
	@Column(name = "name")
	private String name;

	@Column(name = "mobno")
	private Integer mobno;

	@Column(name = "age")
	private Integer age;

	@Column(name = "address")
	private String address;
	
	@Column(name="emp_deg")
	private String emp_deg;
	
	@Column(name="sal")
	private Double sal;
}
