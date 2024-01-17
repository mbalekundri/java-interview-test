package com.mphasis.interview.jdk17;

public class InstanceOfPatternTest {

	public static void main(String[] args) {
		
		instanceOfTest(Double.valueOf(100));

	}
	
	private static void instanceOfTest(Object obj) {
		// The following code in JDK 11:
		if (obj instanceof Double) {
		  Double d = (Double) obj;
		  System.out.println(d.intValue());
		}

		// can be expressed in JDK 17 as:
		if (obj instanceof Double d) {
		  System.out.println(d.intValue());
		}
	}

}
