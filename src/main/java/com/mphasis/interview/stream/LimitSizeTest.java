package com.mphasis.interview.stream;

import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class LimitSizeTest {

	public static void main(String[] args) {
		
		List<Employee> employees = CommonUtils.getEmployeesList();
		employees.forEach(System.out::println);
		List<Integer> ages = employees.stream().map(e -> e.getAge()).distinct().sorted().collect(Collectors.toList());
		ages.forEach(System.out::println);
//		employees = employees.stream().limit(2).collect(Collectors.toList());
//		System.out.println("After Limit operation");
//		employees.forEach(System.out::println);

	}

}
