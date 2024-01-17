package com.mphasis.interview.jdk17;

/**
 * Sealed Classes Sealed classes and interfaces restrict which other classes or
 * interfaces may extend or implement them.
 * https://javatechonline.com/java-17-features/
 */

abstract sealed class Shape permits Circle, Triangle, Rectangle {

    abstract String draw();
}

non-sealed class Circle extends Shape {

    @Override
    String draw() {
	return "Circle";
    }
}

non-sealed class Triangle extends Shape {

    @Override
    String draw() {
	return "Triangle";
    }
}

non-sealed class Rectangle extends Shape {

    @Override
    String draw() {
	return "Rectangle";
    }
}

//non-sealed class Octagonal extends Shape{}

public class SealedClassesTest {

    public static void main(String[] args) {

    }

}
