package com.mphasis.interview.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String args[]) {
	List<Integer> numList = new ArrayList<>();
	numList.add(2);
	numList.add(10);
	numList.add(4);
	numList.add(8);

	Function<Integer, Integer> fun = i -> i / 2;
	numList.stream().map(fun).forEach(System.out::println);

	List<String> cities = new ArrayList<>();
	cities.add("Delhi");
	cities.add("Mumbai");
	cities.add("Goa");
	cities.add("Pune");

	Function<String, Character> getFirstCharFunction = city -> {
	    return city.charAt(0);
	};

	cities.stream().map(getFirstCharFunction).forEach(System.out::println);
//	cities.stream().map(city -> {
//	    return city.charAt(0);
//	}).forEach(System.out::println);

    }

}
