package com.mphasis.interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7412650370798191754L;
	
	private int age;
	private String name;

	public Person() {

	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	

}

public class SerializationTest {

	public static void main(String... args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Person p1 = new Person(40, "Rohit");
		Person p2 = null;
		
		try (ObjectOutput oout = new ObjectOutputStream(new FileOutputStream("file_p.txt"))) {
			oout.writeObject(p1);
		}
		
		try (ObjectInput oinput = new ObjectInputStream(new FileInputStream("file_p.txt"))) {
			p2 = (Person)oinput.readObject();
		}
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}

}
