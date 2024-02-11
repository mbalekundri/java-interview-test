package com.mphasis.interview.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mphasis.interview.common.CommonUtils;
import com.mphasis.interview.common.Employee;

/**
 * Find Max salaried employee's name
 */
public class CollectingAndThenExample {
    
    public static void main(String[] args) {
	
	List<Employee> emps = CommonUtils.getEmployeesList();
	String empName = emps.stream().collect(
		Collectors.collectingAndThen(
			Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), 
			(Optional<Employee> emp) -> emp.isPresent() ? emp.get().getName():"None"));
	
	System.out.println("Max salaries employee name: "+ empName);

    }

}
