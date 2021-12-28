package com.collabera.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.entities.Employee;
import com.collabera.services.EmployeeServiceImpl;
import com.collabera.services.ValidationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private ValidationService validationService;

	@GetMapping
	@ApiOperation("Show All Employee Records")
	public List<Employee> employees() {
		return employeeService.getEmployees();
	}

	@PostMapping
	@ApiOperation("Create a New Employee Record")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
		Employee e = null;

		Map<String, String> errorMap = validationService.validate(bindingResult);

		if (errorMap.isEmpty()) {
			e = employeeService.create(employee);
			return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
		}

		else
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/{empId}")
	@ApiOperation("Show an Employee Record")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer empId) {
		Employee emp = employeeService.getEmployee(empId);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

}
