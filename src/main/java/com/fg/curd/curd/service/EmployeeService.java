package com.fg.curd.curd.service;

import java.util.List;

import com.fg.curd.curd.dto.request.EmployeeRequest;
import com.fg.curd.curd.dto.response.EmployeeResponse;
import com.fg.curd.curd.entity.Employee;

public interface EmployeeService {

	EmployeeResponse saveEmp(EmployeeRequest employee);

	void deleteEmployeeById(Long id);

	// List<Employee> getAllEmployees();

	List<EmployeeResponse> getAllEmp();

	Employee updateEmp(Employee employee);

	Employee updatesEmp(Employee employee);

	List<Employee> search(String name, String address, Long id, Integer age, Integer mobno);

//	Employee getEmployeeById(Long id);

	EmployeeResponse getEmpById(Long id);

	List<Employee> findAllDesc();

	List<Employee> findAllAsc();

	List<Employee> getAllEmpdd(Integer pageNumber, Integer pageSize);

}
