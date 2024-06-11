package application;

import javax.swing.JOptionPane;

import model.entities.BinaryTree;
import model.entities.ListaSE;
import model.entities.Student;

public class Program {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		ListaSE list = new ListaSE();
		
		int opt;
		do {
//			System.out.println("Bem vindo ao cadastro de alunos!\n Selecione uma opção:\n1 - Inserir aluno\n2 - Remover aluno\n3 - Buscar Aluno\n4 - Sair");
			opt = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao cadastro de alunos!\n Selecione uma opção:\n0 - Cadastrar Matéria\n1 - Inserir aluno\n2 - Remover aluno\n3 - Buscar Aluno\n4 - Editar Aluno\n5 - Sair"));
			
			switch(opt) {
				case 0:
					insert_subject(list);
					break;
				case 1:
					insert_student(bt);
					break;
				case 2:
					try {
						remove_student(bt);
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 3:
					try {
						find_student(bt);
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 4:
					try {
						edit_student(bt, list);
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				default:
					System.exit(1);
					break;
			}
		}while(opt != 5);
	}
	
	public static void insert_subject(ListaSE list) {
		String name = JOptionPane.showInputDialog("Digite o nome da matéria a ser adicionada!");
		list.insert(name);
		JOptionPane.showMessageDialog(null, "Matéria adicionada com sucesso!");
	}
	
	public static void insert_student(BinaryTree bt) {
		int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do estudante: "));
		String name = JOptionPane.showInputDialog("Digite o nome do estudante: ");
		String email = JOptionPane.showInputDialog("Digite o email do estudante: ");
		
		bt.insert(ra, name, email);
		
		JOptionPane.showMessageDialog(null, "Estudante inserido com sucesso!");
	}
	
	public static void remove_student(BinaryTree bt) throws Exception {
		if(bt.isEmpty()) {
			throw new Exception("Sem estudantes a mostrar! Nada há ser removido!");
		}
		
		int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do estudante desejado: "));
		Student std = bt.search(ra);
		
		if(std != null) {
			bt.remove(ra);
			JOptionPane.showMessageDialog(null, "Aluno seguinte removido!\n" + std.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado e não removido!");
		}
	}
	
	public static void find_student(BinaryTree bt) throws Exception {
		if(bt.isEmpty()) {
			throw new Exception("Sem estudantes a mostrar! Nada há ser removido!");
		}
		
		int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do estudante desejado: "));
		Student std = bt.search(ra);
		
		if(std != null) {
			JOptionPane.showMessageDialog(null, "Aluno encontrado!\n" + std.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
		}
	}
	
	public static void edit_student(BinaryTree bt, ListaSE list) throws Exception {
		if(bt.isEmpty()) {
			throw new Exception("Sem estudantes a mostrar! Nada há ser removido!");
		}
	
		int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do estudante desejado: "));
		Student std = bt.search(ra);
		
		if(std != null) {
			int opt = Integer.parseInt(JOptionPane.showInputDialog("Aluno encontrado!\n" + std.toString() + "\nO que gostaria de editar?\n1 - Nome\n2 - Email\n3 - Adicionar matéria\n4 - Remover Matéria\n"));
			switch(opt) {
				case 1:
					String name = JOptionPane.showInputDialog("Digite o novo nome: ");
					std.setName(name);
					break;
				case 2:
					String email = JOptionPane.showInputDialog("Digite o novo email: ");
					std.setEmail(email);
					break;
				case 3:
					if(list.isEmpty()) {
						throw new Exception("Sem matérias cadastradas! Registre uma matéria para atribui-la a um estudante!");
					}
					String subjects = list.toString();
					String sub = JOptionPane.showInputDialog("Digite a materia desejada para inserir ao aluno:\n Matérias disponíveis: \n" + subjects);
					if(list.contains(sub)) {
						if(std.getSubjects().contains(sub)) {
							JOptionPane.showMessageDialog(null, "Está materia ja está atribuida ao aluno!");
						} else {
							std.addSubject(sub);
							JOptionPane.showMessageDialog(null, "Matéria atribuida ao aluno!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Esta matéria não existe no cadastro do sistema!");
					}
					break;
				case 4:
					if(std.getSubjects().isEmpty()) {
						throw new Exception("Sem matérias cadastradas ao aluno para serem removidas!");
					}
					String subject = JOptionPane.showInputDialog("Matérias que podem ser removidas: " + std.getSubjects().toString() + "Digite o nome da matéria a ser removida:");
					if(std.getSubjects().contains(subject)) {
						std.removeSubject(subject);
						JOptionPane.showMessageDialog(null, "Matéria removida do quadro de aulas do estudante!");
					} else {
						JOptionPane.showMessageDialog(null, "Esta matéria não consta no quadro do aluno!");
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida!");
					break;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
		}
	}
}

