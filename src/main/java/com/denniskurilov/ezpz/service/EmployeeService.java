package com.denniskurilov.ezpz.service;

import com.denniskurilov.ezpz.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EmployeeService {

	int PAGE_SIZE = 10;

	/**
	 * Returns one page of employees ordered by id.
	 *
	 * @param page page number, starting from 1
	 */
	Page<Employee> findPage(int page);

	Optional<Employee> findById(Long id);

	/**
	 * Creates a new employee. Any id on the passed object is ignored.
	 */
	Employee create(Employee employee);

	/**
	 * Copies editable fields from {@code data} to the employee with the given id.
	 *
	 * @return the updated employee, or empty if it does not exist
	 */
	Optional<Employee> update(Long id, Employee data);

	/**
	 * @return the deleted employee, or empty if it does not exist
	 */
	Optional<Employee> delete(Long id);

}
