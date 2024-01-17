package com.mphasis.interview.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExampleTest {

	public static void main(String args[]) {
	      List<Integer> numList = new ArrayList<>();
	      numList.add(5);
	      numList.add(10);
	      numList.add(3);
	      numList.add(8);
	      
	      Predicate<Integer> pred = i -> i > 5;
	      
	      numList.stream().filter(pred).forEach(i -> System.out.println(i));
	   }

}
