package com.mphasis.interview.common;

public class Student {

	private int id;
	private String name;
	private String language;
	private int marks;

	public Student(int id, String name, String language, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
