package com.mphasis.interview;

import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class BasicStreams {

    public static void main(String args[]) {
	List<Employee> filteredList = CommonUtils.getEmployeesList().stream().limit(2).collect(Collectors.toList());
	filteredList.forEach(System.out::println);
    }

}
