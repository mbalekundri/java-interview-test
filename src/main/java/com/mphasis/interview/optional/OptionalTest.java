package com.mphasis.interview.optional;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		String[] words = new String[] { null, "1", null, "2", null, "3" };
		checkNotNullable(words[0]);
		checkNotNullable(words[1]);
		checkNotNullable(words[2]);
		checkNotNullable(words[3]);
		checkNotNullable(words[4]);
		checkNotNullable(words[5]);
	}

	private static void checkNotNullable(String input) {
		Optional<String> checkNull = Optional.ofNullable(input);
		if (checkNull.isPresent()) {
			String word = input.toLowerCase();
			System.out.println(word);
		} else
			System.out.println("word is null");
	}
}
