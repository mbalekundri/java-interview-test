package com.mphasis.interview.jdk17;

/**
 * Sealed Classes Sealed classes and interfaces restrict which other classes or
 * interfaces may extend or implement them.
 * https://javatechonline.com/java-17-features/
 */

abstract sealed class Shape permits Circle, Triangle, Rectangle, Octagonal { // , Octagonal
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

final class Octagonal extends Shape {
    @Override
    String draw() {
	return "Octagonal";
    }
}

public class SealedClassesTest {

    public static void main(String[] args) {
	Shape circle = new Circle();
	System.out.println(circle.draw());

	Shape triangle = new Triangle();
	System.out.println(triangle.draw());

	Shape rectangle = new Rectangle();
	System.out.println(rectangle.draw());
    }
}
