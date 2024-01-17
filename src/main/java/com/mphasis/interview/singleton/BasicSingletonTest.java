package com.mphasis.interview.singleton;

class BasicSingleton {
	private static BasicSingleton singleton;

	private BasicSingleton() {

	}

	public static synchronized BasicSingleton getInstance() {

		if (singleton == null) {
			singleton = new BasicSingleton();
		}
		System.out.println(singleton.hashCode());
		return singleton;
	}

}

public class BasicSingletonTest {

	public static void main(String[] args) {

		System.out.println(BasicSingleton.getInstance());
		System.out.println(BasicSingleton.getInstance());
		System.out.println(BasicSingleton.getInstance());
		System.out.println(BasicSingleton.getInstance());
		System.out.println(BasicSingleton.getInstance());

	}

}
