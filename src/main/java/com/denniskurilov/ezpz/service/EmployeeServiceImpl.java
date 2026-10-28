package com.denniskurilov.ezpz.service;

import com.denniskurilov.ezpz.dao.EmployeeDao;
import com.denniskurilov.ezpz.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Page<Employee> findPage(int page) {
		int pageIndex = Math.max(page, 1) - 1;
		return employeeDao.findAll(PageRequest.of(pageIndex, PAGE_SIZE, Sort.by("id")));
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public Employee create(Employee employee) {
		employee.setId(null);
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public Optional<Employee> update(Long id, Employee data) {
		// The entity is managed, changes are flushed on commit
		return employeeDao.findById(id).map(employee -> {
			employee.setFirstName(data.getFirstName());
			employee.setLastName(data.getLastName());
			employee.setDateOfBirth(data.getDateOfBirth());
			return employee;
		});
	}

	@Override
	@Transactional
	public Optional<Employee> delete(Long id) {
		Optional<Employee> employee = employeeDao.findById(id);
		employee.ifPresent(employeeDao::delete);
		return employee;
	}

}
