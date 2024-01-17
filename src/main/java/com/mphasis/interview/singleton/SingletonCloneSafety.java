package com.mphasis.interview.singleton;

//Java code to explain overcome
//cloning issue with singleton

class SuperClass implements Cloneable {
	int i = 10;

	@Override
	protected Object clone()
		throws CloneNotSupportedException
	{
		return super.clone();
	}
}

//Singleton class
class Singleton4 extends SuperClass {

	// public instance initialized when loading the class
	public static Singleton4 instance = new Singleton4();

	private Singleton4()
	{
		// private constructor
	}

	@Override
	protected Object clone()
		throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}

public class SingletonCloneSafety {

	// Main driver method
	public static void main(String[] args)
		throws CloneNotSupportedException
	{
		Singleton4 instance1 = Singleton4.instance;
		Singleton4 instance2 = (Singleton4)instance1.clone();

		System.out.println("instance1 hashCode:- "
						+ instance1.hashCode());
		System.out.println("instance2 hashCode:- "
						+ instance2.hashCode());
	}
}

