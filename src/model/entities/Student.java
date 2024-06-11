package model.entities;

public class Student {
	int ra;
	String name;
	String email;
	
	ListaSE subjects;
	
	public Student(int ra, String name, String email) {
		this.ra = ra;
		this.name = name;
		this.email = email;
		subjects = new ListaSE();
	}
	
	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addSubject(String name) {
		subjects.insert(name);
	}
	
	public void removeSubject(String name) {
		subjects.remove(name);
	}
	
	public ListaSE getSubjects() {
		return subjects;
	}
	
	@Override
	public String toString() {
		return "RA: " + ra + "\nNome: " + name + "\nEmail:" + email + "\n" + "Matérias:\n" + subjects.toString();
	}
}
