package com.fg.curd.curd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.fg.curd.curd.dto.request.EmployeeRequest;
import com.fg.curd.curd.dto.response.EmployeeResponse;
import com.fg.curd.curd.entity.Employee;
import com.fg.curd.curd.repository.EmployeeRepository;
import com.fg.curd.curd.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository;

	
	@Override
	public EmployeeResponse saveEmp(EmployeeRequest employee) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(employee, emp);
		Employee empRs = employeerepository.save(emp);
		EmployeeResponse empRes = new EmployeeResponse();
		BeanUtils.copyProperties(empRs, empRes);
		return empRes;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeerepository.deleteById(id);
	}

//	@Override
//	public List<Employee> getAllEmployees() {
//		return employeerepository.findAll();
//	}

	@Override
	public List<EmployeeResponse> getAllEmp() {
		List<Employee> emprs = employeerepository.findAll();
		List<EmployeeResponse> employeeresponse = new ArrayList<>();
		for (Employee employee : emprs) {
			EmployeeResponse empres = new EmployeeResponse();
			BeanUtils.copyProperties(employee, empres);
			employeeresponse.add(empres);
		}
		return employeeresponse;
	}

	@Override
	public Employee updateEmp(Employee employee) {
		Optional<Employee> emp = employeerepository.findById(employee.getId());
		if (emp.isPresent()) {
			emp.get().setName(employee.getName());
			emp.get().setAddress(employee.getAddress());
			emp.get().setAge(employee.getAge());
			emp.get().setMobno(employee.getMobno());
			emp.get().setEmp_deg(employee.getEmp_deg());
			emp.get().setSal(employee.getSal());
			return employeerepository.save(emp.get());
		}
		return null;
	}

	@Override
	public Employee updatesEmp(Employee employee) {
		Optional<Employee> emp = employeerepository.findById(employee.getId());
		if (emp.isPresent()) {
			emp.get().setName(employee.getName());
			return employeerepository.save(emp.get());
		}
		return null;
	}

	@Override
	public List<Employee> search(String name, String address, Long id, Integer age, Integer mobno) {
		return (List<Employee>) employeerepository.findAll();
	}

//	@Override
//	public Employee getEmployeeById(Long id) {
//		return employeerepository.findById(id).get();
//	}

	public EmployeeResponse getEmpById(Long id) {
		Optional<Employee> empRs = employeerepository.findById(id);
		EmployeeResponse empRes = new EmployeeResponse();
		BeanUtils.copyProperties(empRs.get(), empRes);
		return empRes;
	}

	@Override
	public List<Employee> findAllDesc() {
		return employeerepository.findAll(Sort.by("id").descending());
	}

	@Override
	public List<Employee> findAllAsc() {
		return employeerepository.findAll(Sort.by("id").ascending());
	}
	
	public List<Employee> getAllEmpdd(Integer pageNumber, Integer pageSize)
	{
		
		Pageable p=PageRequest.of(pageNumber,pageSize);
		Page<Employee> pageEmp=employeerepository.findAll(p);
//		List<Employee>allemployee=pageEmp.getContent();
//		return 	allemployee;	
		return pageEmp.getContent();
	}
}