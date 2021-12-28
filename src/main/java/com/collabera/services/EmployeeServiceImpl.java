package com.collabera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.entities.Employee;
import com.collabera.exceptions.EmployeeNotFoundException;
import com.collabera.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Integer empId, Employee employee) {
		Employee emp = employeeRepository.findById(empId).orElse(null);

		if (emp != null) {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setAddress(employee.getAddress());
			emp.setSalary(employee.getSalary());

			employeeRepository.save(emp);
			return emp;
		}

		return null;
	}

	@Override
	public void delete(Integer empId) {
		Employee emp = employeeRepository.findById(empId).orElse(null);

		if (emp != null) {
			employeeRepository.delete(emp);
		}
	}

	@Override
	public Employee getEmployee(Integer empId) {
		Employee emp = employeeRepository.findById(empId).orElse(null);

		if (emp == null)
			throw new EmployeeNotFoundException("Employee Doesn't Exist With empId: " + empId);

		else
			return emp;

	}

}

//Layered architecture
//controller layer
//service or business layer 
//dao or persistence layer
