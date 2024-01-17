package com.mphasis.interview.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {

		Consumer<Integer> consumer = i -> System.out.print(" " + i);
		Consumer<Integer> consumerWithAndThen = consumer.andThen(i -> System.out.print("(printed " + i + ")"));
		List<Integer> integerList = Arrays.asList(Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(200),
				Integer.valueOf(101), Integer.valueOf(-10), Integer.valueOf(0));
		printList(integerList, consumerWithAndThen);
	}

	public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
		for (Integer integer : listOfIntegers) {
			consumer.accept(integer);
		}

	}

}
