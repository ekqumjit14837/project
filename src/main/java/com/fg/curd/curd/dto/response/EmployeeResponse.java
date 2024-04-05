package com.fg.curd.curd.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmployeeResponse {

	private Long id;
	private String name;
	private Integer mobno;
	private Integer age;
	private String address;	
	private String emp_deg;
	private Double sal;
}
