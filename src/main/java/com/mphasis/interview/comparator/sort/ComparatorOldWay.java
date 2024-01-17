package com.mphasis.interview.comparator.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class ComparatorOldWay {

    public static void main(String args[]) {
	List<Employee> employeeList = CommonUtils.getEmployeesList();
	Collections.sort(employeeList, new EmployeeComparator());
	employeeList.forEach(System.out::println);
    }

}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
	return (emp1.getName().compareTo(emp2.getName()));
    }
}
