package com.mphasis.interview.stream.group;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mphasis.interview.common.CommonUtils;
import com.mphasis.interview.common.Department;
import com.mphasis.interview.common.EmployeeDept;

/**
 * Interview question: Find employee details who is having highest salary in
 * each department
 */
public class HighestSalaryEachDepartment {

    public static void main(String[] args) {
	List<EmployeeDept> empDepts = CommonUtils.getEmployeeDeptList();
	Map<Department, List<EmployeeDept>> groupResult = empDepts.stream()
		.collect(Collectors.groupingBy(EmployeeDept::getDepartment));
	System.out.println(groupResult);
	
	printDeptEmpName();
	
	printDeptEmpSalary();

    }
    
    /**
     * 
     */
    private static void printDeptEmpSalary() {
	System.out.println("--------------------------------------------------");
	List<EmployeeDept>  empDepts = CommonUtils.getEmployeeDeptList();
	Map<Department, Double> result = empDepts.stream()
		.collect(Collectors.groupingBy(EmployeeDept::getDepartment,
			Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(EmployeeDept::getSalary)),
				emp -> emp.get().getSalary())));
	System.out.println(result);
    }

    /**
     * 
     */
    private static void printDeptEmpName() {
	System.out.println("--------------------------------------------------");
	List<EmployeeDept>  empDepts = CommonUtils.getEmployeeDeptList();
	Map<Department, String> result = empDepts.stream()
		.collect(Collectors.groupingBy(EmployeeDept::getDepartment,
			Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(EmployeeDept::getSalary)),
				emp -> emp.get().getName())));
	System.out.println(result);
    }

}
