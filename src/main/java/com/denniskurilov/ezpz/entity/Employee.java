package com.denniskurilov.ezpz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "First name is required")
	@Size(max = 100, message = "First name must be at most 100 characters")
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Size(max = 100, message = "Last name must be at most 100 characters")
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;

	@PastOrPresent(message = "Date of birth cannot be in the future")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	// Filled by the database (UTC), never written by the application
	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

}
