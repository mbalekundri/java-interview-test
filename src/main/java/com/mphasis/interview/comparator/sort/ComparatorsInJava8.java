package com.mphasis.interview.comparator.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class ComparatorsInJava8 {

    public static void main(String[] args) {
	List<Employee> employeeList = CommonUtils.getEmployeesList();
	
	// Java 8 Comparator natural order sorting
	List<String> empNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
	empNames.sort(Comparator.naturalOrder());
	empNames.forEach(System.out::println);

	// Defining a Comparator using lambda expression
	Comparator<Employee> empNameComparator = (Employee emp1, Employee emp2) -> {
	    return (emp1.getName().compareTo(emp2.getName()));
	};
	Collections.sort(employeeList, empNameComparator);
	employeeList.forEach(System.out::println);

	// Java 8 Comparator order reversal using reversed() method
	empNameComparator = Comparator.comparing(Employee::getName).reversed();
	Collections.sort(employeeList, empNameComparator);
	employeeList.forEach(System.out::println);
    }

}
