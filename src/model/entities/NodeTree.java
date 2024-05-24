package model.entities;

public class NodeTree {
	Student student;
	NodeTree left, right;
	
	public NodeTree(int ra, String name) {
		this.student = new Student(ra, name);
		this.left = this.right = null;
	}
	
}
