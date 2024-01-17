package com.mphasis.interview.repeatable_annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Colors {
	Color[] value();
}

@Repeatable(Colors.class)
@interface Color {
	String name();
}

@Color(name = "red")
@Color(name = "blue")
@Color(name = "green")
class Shirt {
}

public class Shirt_Demo {

	public static void main(String... args) {
		int i = 9;
		Integer j = i;
		System.out.println(i + "" + j);
		Color[] colorArray = Shirt.class.getAnnotationsByType(Color.class);
		for (Color color : colorArray) {
			System.out.println(color.name());
		}
	}

}
