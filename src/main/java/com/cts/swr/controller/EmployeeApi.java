package com.cts.swr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swr.exception.EmployeeException;
import com.cts.swr.model.Employee;
import com.cts.swr.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/emps")
public class EmployeeApi {
@Autowired
private EmployeeService empService;

@GetMapping
public ResponseEntity<List<Employee>> findAll() {
//	try {
//		Thread.sleep(5000);
//	}
//	catch(InterruptedException e) {
//		e.printStackTrace();
//	}
        return new ResponseEntity<List<Employee>>(empService.findAll(), HttpStatus.OK);
}

@GetMapping("/{empId:[0-9]{1,4}}")
public ResponseEntity<Employee> findById(@PathVariable("empId") Long empId) {
         ResponseEntity<Employee> response = null;
         Employee emp = empService.findById(empId);
           if (emp == null) {
                 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
           } else {
                 response = new ResponseEntity<>(emp, HttpStatus.OK);
         }
               return response;

       }

@GetMapping("/mobileNumber:[1-9][0-9]{9}")
public ResponseEntity<Employee> findByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {
           ResponseEntity<Employee> response = null;
           Employee emp = empService.findByMobileNumber(mobileNumber);
           if (emp == null) {
                  response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
           } else {
                  response = new ResponseEntity<>(emp, HttpStatus.OK);
          }
           return response;

       }

@PostMapping
public ResponseEntity<Employee> createEmployee(@RequestBody Employee empId) throws EmployeeException {
           empId = empService.add(empId);
           return new ResponseEntity<>(empId, HttpStatus.CREATED);
}

@PutMapping
public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) throws EmployeeException {
         emp = empService.save(emp);
         return new ResponseEntity<>(emp, HttpStatus.OK);

}

@DeleteMapping("/{empId}")
public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") Long empId) {
       ResponseEntity<Void> response = null;
        Employee empTemp = empService.findById(empId);
        if (empTemp == null) {
             response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            empService.deleteById(empId);
               response = new ResponseEntity<>(HttpStatus.OK);
        }
            return response;
    }

}
