package com.mphasis.interview.compare;

import java.util.Collections;
import java.util.List;

import com.mphasis.interview.common.CommonUtils;
import com.mphasis.interview.common.Employee;

public class ComparatorTest {

    public static void main(String[] args) {
	
	List<Employee> emps = CommonUtils.getEmployeesList();
	
	for (Employee employee : emps) {
	    System.out.println(employee);
	}
	
	Collections.sort(emps, new SalaryComparator());
	
	System.out.println("=================================================");
	
	for (Employee employee : emps) {
	    System.out.println(employee);
	}

    }

}
