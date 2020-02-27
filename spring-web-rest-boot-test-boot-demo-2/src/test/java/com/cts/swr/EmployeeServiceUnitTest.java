package com.cts.swr;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.swr.dao.EmployeeRepository;
import com.cts.swr.model.Department;
import com.cts.swr.model.Employee;
import com.cts.swr.service.EmployeeService;
import com.cts.swr.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceUnitTest {
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration{
		
		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}
	@Autowired
	private EmployeeService employeeservice;
	@MockBean
	private EmployeeRepository employeerepository;
	@Before
	public void setUp() {
		Employee emp=new Employee("nikhila","damaraju",45000,LocalDate.now(),Department.DEVELOPEMENT,"9493720887","nikhiladamaraju30@gmail.com");
		Mockito.when(employeerepository.findByMobileNumber(emp.getMobileNumber())).thenReturn(emp);
	}
	@Test
	public void whenValidMobileNumber_thenEmployeeShouldBeFound() {
		String mno="9493720887";
		Employee found=employeeservice.findByMobileNumber(mno);
		assertThat(found.getMobileNumber()).isEqualTo(mno);
	}
	@Test
	public void whenInvalidMobileNumber_thenEmployeeShouldNotBeFound() {
		String mno="123456789";
		Employee found=employeeservice.findByMobileNumber(mno);
		assertThat(found).isNull();
	}
}
