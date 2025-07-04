package com.mphasis.interview.hp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumber {

    public static void main(String[] args) {
	
	Integer[] array1 = {45, 51, 28, 75, 49, 42};
	Integer[] array2 = {45};
	Integer[] array3 = {45, 45, 45, 45, 45};
	Integer[] array4 = {45, 46};
	
	
	List<Integer> input = Arrays.asList(array1);
	
	//Find second largest number
	Integer result = input.stream()
				.distinct()
				.sorted(Collections.reverseOrder())
				.limit(2)
				.skip(1)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Atleast 2 unique intergers to be assigned"));
	System.out.println("second largest number: "+result);
	
	//Find 5th largest number
	result = input.stream()
		.distinct()
		.sorted(Collections.reverseOrder())
		.limit(5)
		.skip(4)
		.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Atleast 2 unique intergers to be assigned"));
	System.out.println("Fifth largest number: "+result);
    }

}
