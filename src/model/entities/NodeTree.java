package model.entities;

public class NodeTree {
	Student student;
	NodeTree left, right;
	
	public NodeTree(int ra, String name, String email) {
		this.student = new Student(ra, name, email);
		this.left = this.right = null;
	}
	
}
