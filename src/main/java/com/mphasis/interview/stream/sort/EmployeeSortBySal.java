package com.mphasis.interview.stream.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Department;
import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.EmployeeDept;
import com.mphasis.interview.common.Gender;
import com.mphasis.interview.common.CommonUtils;

public class EmployeeSortBySal {

    public static void main(String[] args) {
	// Group by Gender like -> (MALE: 3)  (FEMALE: 2)
	List<Employee> employees = CommonUtils.getEmployeesList();
	Map<Gender, Long> val = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
	System.out.println(val);
	
	//List all distinct and sorted department names in getEmployeeDeptList
	List<EmployeeDept> employeeDeptList = CommonUtils.getEmployeeDeptList();
	List<String> deptNames = employeeDeptList.stream().map(ed -> ed.getDepartment().toString()).distinct().sorted().collect(Collectors.toList());
//	deptNames.forEach(d -> System.out.println(d));
	deptNames.forEach(System.out::println);
	
	//Display employee details who is having highest salary
	employeeDeptList = CommonUtils.getEmployeeDeptList();
	employeeDeptList = employeeDeptList.stream().sorted(Comparator.comparingDouble(EmployeeDept::getSalary)).collect(Collectors.toList());
	employeeDeptList.forEach(System.out::println);
	System.out.println("Top most salary employee --> : "+employeeDeptList.get(0));
	System.out.println("Second highest salary employee --> : "+employeeDeptList.get(1));
	System.out.println("Third highest salary employee --> : "+employeeDeptList.get(2));
	Map<Department,String> deptEmpMap = new HashMap<>();
	employeeDeptList.stream().map(empDept -> deptEmpMap.put(empDept.getDepartment(), empDept.getName()));
	System.out.println(deptEmpMap);
    }	

}
