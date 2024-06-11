package model.entities;

public class ListaSE {
    private Node head; // Cabeça da lista

    public ListaSE() {
        this.head = null;
    }

    public void insert(String name) {
        // Insere um nó no início da lista.
        Node new_node = new Node(new Subject(name));
        new_node.next = this.head;
        this.head = new_node;
    }

    public boolean remove(String name) {
        // Remove um nó da lista pelo valor.
        Node current = this.head;
        Node prev = null;
        while (current != null) {
            if (current.subject.name == name) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    this.head = current.next;
                }
                return true; // Dado encontrado e removido
            }
            prev = current;
            current = current.next;
        }
        return false; // Dado não encontrado
    }

    @Override
    public String toString() {
        String str = "";
        // Exibe os elementos da lista.
    	if(head != null) {
            Node current = this.head;
            while (current != null) {
                str += " - " + current.subject.name + "\n";
                current = current.next;
            }
            System.out.println("None");	
    	} else {
    		str += " - Nada há ser exibido!\n";
    	}
    	
        return str;
    }
    
    public boolean isEmpty() {
    	return head == null;
    }
    
    public boolean contains(String name) {
    	Node current = head;
    	while(current != null) {
    		if(current.subject.name.equals(name)) {
    			return true;
    		}
    		current = current.next;
    	}
    	
    	return false;
    }
}
