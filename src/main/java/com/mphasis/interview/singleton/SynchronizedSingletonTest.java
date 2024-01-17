package com.mphasis.interview.singleton;

public class SynchronizedSingletonTest {
	
	private static SynchronizedSingletonTest singleton = new SynchronizedSingletonTest();
	
	private SynchronizedSingletonTest() {
		
	}
	
	public static synchronized SynchronizedSingletonTest getInstance() {
		System.out.println(singleton.hashCode());
		return singleton;
	}

	public static void main(String[] args) {
		
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());

	}

}
