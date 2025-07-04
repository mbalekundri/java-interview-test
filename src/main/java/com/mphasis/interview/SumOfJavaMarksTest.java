package com.mphasis.interview;

import java.util.List;

import com.mphasis.interview.common.Student;
import com.mphasis.interview.common.CommonUtils;

// Find sum of marks of all students who have java language (filter -> map -> reduce using Stream API)
public class SumOfJavaMarksTest {

	public static void main(String[] args) {
		
		List<Student> students = CommonUtils.getStudentsList();
		Integer sumOfMarks = students
			.stream()
			.filter(s -> s.getLanguage().equalsIgnoreCase("java"))
			.map(s -> s.getMarks())
			.reduce(Integer::sum)
			.get();
		System.out.println(sumOfMarks);
	}

}
