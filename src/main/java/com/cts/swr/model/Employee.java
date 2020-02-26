package com.cts.swr.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long empId;
	
	@NotEmpty(message="firstname should not be empty")
	@NotNull(message="firstname cannot be omitted")
	private String firstName;
	
	@NotEmpty(message="lastname should not be empty")
	@NotNull(message="lastname cannot be omitted")
	private String lastName;
	
	@Min(value=25000,message="Basic should not be less than 25000")
	@Max(value=45000,message="Basic cannot be less than 4.5lakh")
	private double basic;

	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate joinDate;

	@Enumerated(EnumType.STRING)
	private Department dept;
	
	@Pattern(regexp="[1-9][0-9]{9}",message="Mobile number is expected to be 10 digits")
	@NotNull(message="mobile number cannote be ommited")
	private String mobileNumber;
	
	@Email(message="email must be valid one")
	@NotNull(message="email cannot be ommited")
	private String email;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
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

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
