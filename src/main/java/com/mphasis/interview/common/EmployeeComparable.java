package com.mphasis.interview.common;

public class EmployeeComparable implements Comparable<EmployeeComparable>{
    
    private String name;
    private Integer age;
    private Double salary;
    private Gender gender;

    public EmployeeComparable(String name, Integer age, Double salary, Gender gender) {
	this.name = name;
	this.age = age;
	this.salary = salary;
	this.gender = gender;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public Double getSalary() {
	return salary;
    }

    public void setSalary(Double salary) {
	this.salary = salary;
    }

    public Gender getGender() {
	return gender;
    }

    public void setGender(Gender gender) {
	this.gender = gender;
    }

    public String toString() {
	return "Employee Name: " + this.name + "  Age: " + this.age + "  Salary: " + this.salary;
    }

    @Override
    public int compareTo(EmployeeComparable e) {
	
	if(this.getName().compareTo(e.getName()) > 0) {
	    return 1;
	} else if (this.getName().compareTo(e.getName()) < 0) {
	    return -1;
	} else {
	    return 0;
	}
    }
}
