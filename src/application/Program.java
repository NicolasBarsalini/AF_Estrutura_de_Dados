package application;

import java.util.Scanner;

import model.entities.BinaryTree;

public class Program {

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		int opt;
		do {
			System.out.println("Bem vindo ao cadastro de alunos!\n Selecione uma opção:\n1 - Inserir aluno\n2 - Remover aluno\n3 - Buscar Aluno\n4 - Sair");
			opt = sc.nextInt();
			
			switch(opt) {
				case 1:
					insert_student();
					break;
				case 2:
					// remove_student();
					break;
				case 3:
					// find_student();
					break;
				default:
					sc.close();
					System.exit(1);
			}
		}while(opt != 4);
	}
	
	public static void insert_student() {
		System.out.println("Entrou!");
	}*/
		
		BinaryTree tree = new BinaryTree();
		
		tree.insert(222259, "Nicolas");
		tree.insert(223026, "lucas");
		
		System.out.println(tree.search(223026));
	}

}
