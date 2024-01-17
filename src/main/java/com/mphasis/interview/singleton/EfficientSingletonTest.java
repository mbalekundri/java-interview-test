package com.mphasis.interview.singleton;

/**
 * Most Efficient || Use “Double Checked Locking” to implement singleton design
 * pattern
 */
//Double Checked Locking based Java implementation of
//singleton design pattern
class EfficientSingletonTest {

	private static volatile EfficientSingletonTest obj = null;

	private EfficientSingletonTest() {
	}

	public static EfficientSingletonTest getInstance() {
		if (obj == null) {
			// To make thread safe
			synchronized (BasicSingletonTest.class) {
				// check again as multiple threads
				// can reach above step
				if (obj == null) {
					obj = new EfficientSingletonTest();
				}

			}
		}
		System.out.println(obj.hashCode());
		return obj;
	}

	public static void main(String[] args) {

		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());

	}
}
