package com.denniskurilov.ezpz.dao;

import com.denniskurilov.ezpz.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
