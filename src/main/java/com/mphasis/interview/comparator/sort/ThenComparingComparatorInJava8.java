package com.mphasis.interview.comparator.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class ThenComparingComparatorInJava8 {

    public static void main(String[] args) {
	// Comparator's thenComparing() method for multiple sort criteria
	Comparator<Employee> empNameAgeComparator = Comparator.comparing(Employee::getName)
		.thenComparing(Employee::getAge);
	List<Employee> employeeList = CommonUtils.getEmployeesList();
	Collections.sort(employeeList, empNameAgeComparator);
	employeeList.forEach(System.out::println);
    }

}
