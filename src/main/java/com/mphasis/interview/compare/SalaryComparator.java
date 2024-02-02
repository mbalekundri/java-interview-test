package com.mphasis.interview.compare;

import java.util.Comparator;

import com.mphasis.interview.common.Employee;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
	return e1.getSalary().compareTo(e2.getSalary());
    }

}
