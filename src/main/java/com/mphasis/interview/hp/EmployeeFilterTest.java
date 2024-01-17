package com.mphasis.interview.hp;

import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class EmployeeFilterTest {

	public static void main(String[] args) {
		List<Employee> employeesList = CommonUtils.getEmployeesList().stream().filter(e -> e.getAge()> 30).collect(Collectors.toList());
		employeesList.forEach(System.out::println);
	}

}
