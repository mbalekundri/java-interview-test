package com.mphasis.interview.stream.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class StreamSortedTest {

	public static void main(String[] args) {
		
		List<Employee> employees = CommonUtils.getEmployeesList();
//		employees = employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());
//		employees = employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).collect(Collectors.toList());
		employees = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
//		employees = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
//		employees = employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).collect(Collectors.toList());
//		employees = employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge).reversed()).collect(Collectors.toList());
		employees.forEach(System.out::println);

	}

}
