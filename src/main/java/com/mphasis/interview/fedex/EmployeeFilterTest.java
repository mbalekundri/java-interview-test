package com.mphasis.interview.fedex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.interview.common.Employee;
import com.mphasis.interview.common.CommonUtils;

public class EmployeeFilterTest {

    public static void main(String[] args) {
	
	System.out.println("======All Emplyees list================");
	List<Employee> employeesList = CommonUtils.getEmployeesList().stream().collect(Collectors.toList());
	employeesList.forEach(System.out::println);
	
	System.out.println("======Emplyees list having age > 30 ================");
	employeesList = CommonUtils.getEmployeesList().stream().filter(e -> e.getAge() > 30)
		.collect(Collectors.toList());
	employeesList.forEach(System.out::println);
	
	System.out.println("======Emplyees count having age > 30 ================");
	long value = CommonUtils.getEmployeesList().stream().filter(e -> e.getAge() > 30).count();
	System.out.println(value);
	
	System.out.println("====== Filter 3 Emplyees list having age > 30 age ===============");
	employeesList = CommonUtils.getEmployeesList().stream().filter(e -> e.getAge() > 30).limit(3)
		.collect(Collectors.toList());
	employeesList.forEach(System.out::println);
	
	System.out.println("=======================");
	System.out.println("Print top 3 employees list who is having highest age from employee list");
	employeesList = CommonUtils.getEmployeesList().stream()
		.sorted(
		  Comparator.comparingInt(Employee::getAge).reversed()
		  )
		.limit(3)
		.toList();
	employeesList.forEach(System.out::println);
	
	System.out.println("=============Print employee name who is having highest salary from employee list==========");
	String result = CommonUtils.getEmployeesList().stream().collect(
		Collectors.collectingAndThen(
			Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
			e -> (e.isPresent() ? "Employee with highest sal: "+e.get().getSalary()+" is: "+e.get().getName():" None")
		));
	System.out.println(result);
	
	System.out.println("===========Print employee name who is having highest salary from employee list============");
	String name = CommonUtils.getEmployeesList().stream()
		.sorted(
		  Comparator.comparingDouble(Employee::getSalary).reversed()
		  )
		.limit(1).map(e -> e.getName()).findAny().get();
	System.out.println("Employee name who is having highest salary from employee list: "+name);
	
	System.out.println("Print employee name who is having 2nd highest and 3rd highest salary from employee list");
	employeesList = CommonUtils.getEmployeesList().stream()
		.sorted(
		  Comparator.comparingDouble(Employee::getSalary).reversed()
		  )
		.limit(3)
		.skip(1)
		.collect(Collectors.toList());
	employeesList.forEach(System.out::println);
	
	System.out.println("============Print employee names from employee list========================");
	List<String> empNames	= CommonUtils.getEmployeesList().stream()
				.map(emp -> emp.getName()).sorted().collect(Collectors.toList());
	System.out.println(empNames);			
			
	System.out.println("============Print names from starting with Vovels========================");
	List<String> names = Arrays.asList("Avinash", "Sneha", "Ionist", "Jagaaur", "Ullal", "elephant");
	
	names = names.stream()
			.filter(word -> word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u' ||
			word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I' || word.charAt(0) == 'O' || word.charAt(0) == 'U')
			.collect(Collectors.toList());
	System.out.println(names);
    }

}
