package com.mphasis.interview;

import java.util.List;
import java.util.function.Predicate;

public class SumOfEvenNumbersTest {

	public static void main(String[] args) {
		List<Integer> listOfNo = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Predicate<Integer> pred = n -> n % 2 == 0;
		
//		Integer sumOfEvenNos = listOfNo.stream().filter(pred).reduce(Integer::sum).get();
		Integer sumOfEvenNos = listOfNo.stream().filter(pred).reduce(0, (a,b)->(a+b));
//		Integer sumOfEvenNos = listOfNo.stream().filter(pred).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfEvenNos);

	}

}
