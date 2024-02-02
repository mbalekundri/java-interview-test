package com.mphasis.interview.compare;

import java.util.Collections;
import java.util.List;

import com.mphasis.interview.common.CommonUtils;
import com.mphasis.interview.common.EmployeeComparable;

public class ComparableTest {

    public static void main(String[] args) {
	List<EmployeeComparable> emps = CommonUtils.getEmployeesComparableList();
	Collections.sort(emps, null);
//	Collections.sort(emps);
	emps.forEach(System.out::println);
	
	emps = CommonUtils.getEmployeesComparableList();
//	Collections.sort(emps, null);
//	Collections.sort(emps);
//	emps.forEach(System.out::println);
    }
}



