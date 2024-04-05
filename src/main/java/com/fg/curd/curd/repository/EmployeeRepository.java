package com.fg.curd.curd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fg.curd.curd.entity.Employee;


@Repository


public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
//@Query("SELECT e FROM Employee e WHERE e.name=:name")
//List<Employee>fetchName(@Param(value="name")String name);

//@Query("SELECT e FROM Employee e ORDER BY e.name ASC")
//List<Employee> fetchNameOrderedAscending();

//@Query("SELECT e FROM Employee e ORDER BY e.name DESC")
//List<Employee> fetchNameOrderedDescending();	
}
