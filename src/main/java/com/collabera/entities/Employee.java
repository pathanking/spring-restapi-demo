package com.collabera.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;

	@NotBlank
	@Size(min = 4, max = 20)
	private String firstName;
	@NotBlank
	@Size(min = 4, max = 20)
	private String lastName;
	@NotBlank
	@Size(min = 4, max = 50)
	private String address;

	@Min(value = 2000)
	@Max(value = 10000)
	private Double salary;

	@NotBlank
	@Email
	private String email;

}
