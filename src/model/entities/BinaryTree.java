package model.entities;

// Classe para a árvore binária de busca
public class BinaryTree {
    NodeTree root;

    public BinaryTree() {
        root = null;
    }

    // Método para inserir um novo valor na árvore
    public void insert(int ra, String name) {
        root = insertRec(root, ra, name);
    }

    // Método recursivo para inserir um novo valor
    private NodeTree insertRec(NodeTree root, int ra, String name) {
        if (root == null) {
            root = new NodeTree(ra, name);
            return root;
        }

        if (ra < root.student.ra) {
            root.left = insertRec(root.left, ra, name);
        } else if (ra > root.student.ra) {
            root.right = insertRec(root.right, ra, name);
        }

        return root;
    }

    // Método para buscar um valor na árvore
    public boolean search(int ra) {
        return searchRec(root, ra);
    }

    // Método recursivo para buscar um valor
    private boolean searchRec(NodeTree root, int ra) {
        if (root == null) {
            return false;
        }

        if (ra == root.student.ra) {
            return true;
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
}
