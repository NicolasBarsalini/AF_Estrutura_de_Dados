package model.entities;

// Classe para a árvore binária de busca
public class BinaryTree {
    NodeTree root;

    public BinaryTree() {
        root = null;
    }

    // Método para inserir um novo valor na árvore
    public void insert(int ra, String name, String email) {
        root = insertRec(root, ra, name, email);
    }

    // Método recursivo para inserir um novo valor
    private NodeTree insertRec(NodeTree root, int ra, String name, String email) {
        if (root == null) {
            root = new NodeTree(ra, name, email);
            return root;
        }

        if (ra < root.student.ra) {
            root.left = insertRec(root.left, ra, name, email);
        } else if (ra > root.student.ra) {
            root.right = insertRec(root.right, ra, name, email);
        }

        return root;
    }

    // Método para buscar um valor na árvore
    public Student search(int ra) {
        return searchRec(root, ra);
    }

    // Método recursivo para buscar um valor
    private Student searchRec(NodeTree root, int ra) {
        if (root == null) {
            return null;
        }

        if (ra == root.student.ra) {
            return root.student;
        }

        if (ra < root.student.ra) {
            return searchRec(root.left, ra);
        } else {
            return searchRec(root.right, ra);
        }
    }

    // Método para percorrer a árvore em ordem
    public void inorder() {
        inorderRec(root);
    }

    // Método recursivo para percorrer a árvore em ordem
    private void inorderRec(NodeTree root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.student);
            inorderRec(root.right);
        }
    }
    
    public boolean isEmpty() {
    	return root == null;
    }
    
    public void remove(int ra) {
    	root = removeRec(root, ra);
    }
    
    public NodeTree removeRec(NodeTree root, int ra) {
    	if(root == null) {
    		return root;
    	}
    	
    	if(ra < root.student.ra) {
    		root.left = removeRec(root.left, ra);
    	} else if(ra > root.student.ra) {
    		root.right = removeRec(root.right, ra);
    	} else {
    		if(root.left == null) {
    			return root.right;
    		} else if(root.right == null) {
    			return root.left;
    		}
    		
    		root.student = findMin(root.right).student;
    		root.right = removeRec(root.right, root.student.ra);
    	}
    	
    	return root;
    }
    
    // Método para encontrar o menor valor em uma subárvore
    private NodeTree findMin(NodeTree root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
