package com.mphasis.interview.jdk17;

import java.util.Random;

public class SwitchStatementTest {

    public static void main(String... args) {
	evaluateDay(DAY.TUESDAY);
	evaluateDay(DAY.SUNDAY);
	evaluateDay(DAY.TUESDAY);
	evaluateDay(DAY.THURSDAY);
	evaluateDay(DAY.SATURDAY);

	System.out.println(evaluateMonthYear(1, 2022));
	System.out.println(evaluateMonthYear(2, 2023));
	System.out.println(evaluateMonthYear(3, 2024));

    }

    private static void evaluateDay(DAY day) {
	switch (day) {
	case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println(day + " is weekday");
	case SATURDAY, SUNDAY -> System.out.println(day + " is weekend");
	}
    }

    private static int evaluateMonthYear(int month, int year) {
	int daysOfMonth = switch (month) {
	case 2 -> {
	    if (isLeapYear(year)) {
		yield 29;
	    } else {
		yield 28;
	    }
	}
	case 4, 6, 9, 11 -> 30;
	default -> 31;
	};
	return daysOfMonth;
    }

    private static boolean isLeapYear(int year) {
	return new Random().nextBoolean();
    }

}

enum DAY {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}