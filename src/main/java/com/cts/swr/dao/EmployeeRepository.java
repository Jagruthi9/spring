package com.cts.swr.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.swr.model.Department;
import com.cts.swr.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
		
		boolean existsByMobileNumber(String mobileNumber);
		boolean existsByEmail(String email);
		Employee findByMobileNumber(String mobileNumber);
		Employee findByEmail(String email);
		List<Employee> findAllByDept(Department dept);
		List<Employee> findAllByJoinDate(LocalDate joinDate);
		
		@Query("SELECT e from Employee e WHERE e.basic>=:lb and e.basic<:ub")
		List<Employee> findAllByBasicRange(double lb,double ub);
}
