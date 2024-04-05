
package com.fg.curd.curd.dto.request;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

	private Long id;
	
	@NotBlank(message="Name field can't be blank")
	@NotEmpty(message="Please enter your name")
	private String name;
	
	private Integer mobno;
	private Integer age;
	private String address;
	private String emp_deg;
	private Double sal;
}
