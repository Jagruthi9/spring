package com.cts.swr;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.swr.dao.EmployeeRepository;
import com.cts.swr.model.Department;
import com.cts.swr.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeDaoUnitTest {
private Employee emps[];
@Autowired
private TestEntityManager entityManager;
@Autowired
private EmployeeRepository employeeRepository;

public EmployeeDaoUnitTest() {
emps = new Employee[] {
new Employee("vamsy","Bindu",45000,
LocalDate.now(),Department.DEVELOPEMENT,
"9494658521","gvmcreddy.it@gmail.com")
};
}
@Before
public void beforeEachTest() {
for(Employee e:emps) {
entityManager.persist(e);
}
entityManager.flush();
}
@After
public void afterEachTest() {
for(Employee e:emps) {
entityManager.remove(e);
}
entityManager.flush();
}

 @Test
public void whenFindByMobileNumber_thenReturnEmployee() {
Employee e = employeeRepository.findByMobileNumber(emps[0].getMobileNumber());
assertThat(e).isEqualTo(emps[0]);

}
public void whenFindByMobileNumber_withNonExistingMobileNumber_thenReturnNull() {
Employee e = employeeRepository.findByMobileNumber("1489652441");
assertThat(e).isNull();
}

}
