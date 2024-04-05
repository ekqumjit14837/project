package com.fg.curd.curd.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fg.curd.curd.dto.request.EmployeeRequest;
import com.fg.curd.curd.dto.response.EmployeeResponse;
import com.fg.curd.curd.entity.Employee;
import com.fg.curd.curd.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@ResponseBody
//@RestController //(Except use this two annotation we can use only this annotation)
@RequestMapping("/test")
public class EmployeeController 
{

	@Autowired
	private EmployeeService  employeeService;	
	
	@PostMapping("/save")
	public EmployeeResponse save(@RequestBody EmployeeRequest employee) 
	{
		return employeeService.saveEmp(employee);
		
	}
	  
	@PutMapping("/emp/update")  
	private Employee update(@Valid @RequestBody Employee employee)   
	{  
		return employeeService.updateEmp(employee);  
	   
	} 
	
	@PatchMapping("/patch/id")
	private Employee updates(@RequestBody Employee employee)
	{
	return employeeService.updatesEmp(employee);	
	}

//	@GetMapping("/getById/{id}")
//	public Employee getEmployeeById(@PathVariable(value="id") Long id)
//	{
//		 return employeeService.getEmployeeById(id);
//	}
	
	@GetMapping("/getById/{id}")
	public EmployeeResponse getEmpById(@PathVariable(value="id")Long id)
	{
		return employeeService.getEmpById(id);
	}
	
    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable(value="id") Long id)
    {
        employeeService.deleteEmployeeById(id);
    }
    
//    @GetMapping("/getAll")
//    public List<Employee> getAllEmployees() 
//	{
//        return employeeService.getAllEmployees();
//    }
    
    @GetMapping("/getall")
    public  List<EmployeeResponse> getAllEmp()
    {
    	return employeeService.getAllEmp();
    }
    
    @GetMapping("/desc")
    public List<Employee> findAllDesc() 
	{
        return employeeService.findAllDesc();
    }
    
    @GetMapping("/asc")
    public List<Employee>findAllAsc()
    {
    	return employeeService.findAllAsc();
    }
    
    
    @GetMapping("/pagination")
    public List<Employee> findAll(
    		@RequestParam(value="pageNumber",defaultValue="1")Integer pageNumber,
    		@RequestParam(value="pageSize",defaultValue="10")Integer pageSize)
    {
    	return employeeService.getAllEmpdd(pageNumber,pageSize);
    }
}
