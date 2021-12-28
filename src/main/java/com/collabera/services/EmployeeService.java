package com.collabera.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.collabera.entities.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee create(Employee employee);

	public Employee update(Integer empId, Employee employee);

	public void delete(Integer empId);

	public Employee getEmployee(Integer empId);

}
