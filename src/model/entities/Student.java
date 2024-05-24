package model.entities;

public class Student {
	int ra;
	String name;
	
	public Student(int ra, String name) {
		this.ra = ra;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "RA: " + ra + " Name: " + name;
	}
}
