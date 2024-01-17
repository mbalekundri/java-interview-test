package com.mphasis.interview.common;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {

    public static List<Employee> getEmployeesList() {
	return Arrays.asList(new Employee("Rohit Balekundri", 45, 7000.00, Gender.MALE),
		new Employee("Vaagish Shanmuga", 25, 10000.00, Gender.MALE),
		new Employee("Santosh Keerti", 65, 8000.00, Gender.MALE),
		new Employee("Rashmika Balekundri", 22, 12000.00, Gender.FEMALE),
		new Employee("Sneha Ullal", 29, 9000.00, Gender.FEMALE));
    }

    public static List<Student> getStudentsList() {
	List<Student> studentList = new ArrayList<>();
	studentList.add(new Student(1, "Mohit", "Java", 70));
	studentList.add(new Student(3, "Prashant", "C++", 70));
	studentList.add(new Student(4, "Harish", "C", 50));
	studentList.add(new Student(2, "Rohit", "Java", 80));
	return studentList;
    }

    public static List<EmployeeDept> getEmployeeDeptList() {
	return Arrays.asList(new EmployeeDept("Tom Jones", 45, 12000.00, Department.MARKETING),
		new EmployeeDept("Harry Major", 26, 20000.00, Department.LEGAL),
		new EmployeeDept("Ethan Hardy", 65, 30000.00, Department.LEGAL),
		new EmployeeDept("Nancy Smith", 22, 15000.00, Department.MARKETING),
		new EmployeeDept("Catherine Jones", 21, 18000.00, Department.HR),
		new EmployeeDept("James Elliot", 58, 24000.00, Department.OPERATIONS),
		new EmployeeDept("Frank Anthony", 58, 32000.00, Department.MARKETING),
		new EmployeeDept("Michael Reeves", 40, 45000.00, Department.OPERATIONS));
    }

    public static File getFileFromResource(String fileName) throws URISyntaxException {
	CommonUtils cu = new CommonUtils();
	return cu.getFileFromResourceInternal(fileName);

    }

    public File getFileFromResourceInternal(String fileName) throws URISyntaxException {
	ClassLoader classLoader = getClass().getClassLoader();
	URL resource = classLoader.getResource(fileName);
	if (resource == null) {
	    throw new IllegalArgumentException("file not found! " + fileName);
	} else {
	    // failed if files have whitespaces or special characters
	    // return new File(resource.getFile());
	    return new File(resource.toURI());
	}

    }

}
