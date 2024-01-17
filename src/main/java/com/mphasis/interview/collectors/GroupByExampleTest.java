package com.mphasis.interview.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Department;
import com.mphasis.interview.common.EmployeeDept;
import com.mphasis.interview.common.CommonUtils;

public class GroupByExampleTest {


    public static void main(String args[]) {
	// Find group of EmployeeDepts by department name
	Map<Department, List<EmployeeDept>> EmployeeDeptMap = CommonUtils.getEmployeeDeptList().stream()
		.collect(Collectors.groupingBy(EmployeeDept::getDepartment));
	System.out.println("EmployeeDepts grouped by department");
	EmployeeDeptMap
		.forEach((Department key, List<EmployeeDept> empList) -> System.out.println(key + " -> " + empList));

	// Find group of EmployeeDepts by EmployeeDept age
	Map<Integer, List<EmployeeDept>> EmployeeDeptMapByAge = CommonUtils.getEmployeeDeptList().stream()
		.collect(Collectors.groupingBy(EmployeeDept::getAge));
	System.out.println("EmployeeDepts grouped by Age");
	EmployeeDeptMapByAge
		.forEach((Integer key, List<EmployeeDept> empList) -> System.out.println(key + " -> " + empList));

    }

}
