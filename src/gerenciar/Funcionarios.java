package gerenciar;

import javax.swing.JOptionPane;

/*
Sistema de gerenciamento de funcionários de uma empresa de software
Será criado um sistema de gerenciamento de funcionários de uma empresa de software.
A empresa possuirá 10 funcionários, os quais serão cadastrados pelo usuário do sistema.
Cada usuário terá código, nome, salário e cargo (Gerente, desenvolvedor, analista e secretário).
Será disponibilizado uma consulta dos funcionários da empresa e seus salários.
Será disponibilizado uma consulta dos funcionários a receberem aumento. Restrições:
O funcionário deve possuir um salário superior a R$ 1300,00 e inferior a R$ 3000,00;
O aumento deve ser distribuído randomicamente, isto é, de forma aleatória, onde a porcentagem de aumento sobre salário atual deve variar entre 10% e 25%.
 
 */

public class Funcionarios {

	// Método para realizar o cadastro de funcionários do sistema
	public static String[][] CadastrarFuncionarios(){
		// Inicializa a matriz de funcionários, com 10 linhas e 3 colunas
		String funcionarios[][] = new String[10][3];
		
		// Solicita a definição dos funcionários para o usuário que está operando do sistema
		for (int i = 0; i < 10; i++){
			
			// Utilizado (i + 1) para que o código seja iniciado em 1, pois em um vetor o primeiro índice é 0
			
			// Solicita o nome do funcionário
			String nome = JOptionPane.showInputDialog("Insira o nome do funcionário " + (i + 1));
			
			// Solicita o salário do funcionário
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o salário do funcionário " + (i + 1)));
			
			// As variáves são instanciadas antes do while, pois senão elas serão acessíveis apenas dentro do while
			boolean valido = false;
			int cargo = 0;
			
			while(!valido) {
				// Solicita o cargo do funcionário
				cargo = Integer.parseInt(JOptionPane.showInputDialog("Insira o cargo do funcionário "  + (i + 1) + " (1 - Gerente, 2 - Desenvolvedor, 3 - Analista, 4 - Secretário)"));
				
				// Verifica se o usuário inseriu uma opção válida para o cargo do funcionário
				// Se for inválida, é necessário informar novamente
				if (cargo != 1 && cargo != 2 && cargo != 3 && cargo != 4)  {
					JOptionPane.showMessageDialog(null, "Valor inválido! Favor preencher corretamente o campo.");
				}
				// Se for válida, é dado sequência para a próxima informação
				else{
					valido = true;
				}
			}	
			
			// Converte o código do cargo do funcionário digitado para o índice do vetor, que se inicia em 0, e n 
			cargo = cargo - 1;
			
			// Grava os dados do funcionário na matriz
			
			// O código do funcionário é a sequência que o mesmo foi inserido (i)
			funcionarios[i][0] = nome;
			
			// Como o tipo de dado da matriz é String, é necessário converter o salário e o cargo, do tipo de dado double e int, respectivamente, para String
			funcionarios[i][1] = String.valueOf(salario); 
			funcionarios[i][2] = String.valueOf(cargo);
		}
		// Retorna a matriz de funcionários, já preenchida
		return funcionarios;
	}
	
	// Método para realizar a consulta de funcionários do sistema
	public static void ConsultarFuncionarios(String[][] funcionarios, String [] cargos){
		
		String dados = "";
		
		// Busca todos os funcionários cadastrados na matriz (sistema)
		for (int i = 0; i < funcionarios.length; i ++){
			
			// Obtém os dados dos funcionários de acordo com a linha e coluna do registro do funcionário
			String nome = funcionarios[i][0];
			double salario = Double.parseDouble(funcionarios[i][1]);
			int cargo = Integer.parseInt(funcionarios[i][2]);
			
			// Obtém a descrição do cargo a partir do código do cargo gravado na matriz
			String descricaoCargo = cargos[cargo];
			
			// Utilizado (i + 1) para que o código seja iniciado em 1, pois em um vetor o primeiro índice é 0
			
			// Imprime as informações do funcionário no console
			dados = dados + "Código: " + (i + 1);
			dados = dados + "   Nome: " + nome;
			dados = dados + "   Cargo: " + descricaoCargo;
			dados = dados + "   Salário: " + salario;
			dados = dados + "\n";
		}
		
		JOptionPane.showMessageDialog(null, dados);
		
	}
	
	// Método para realizar a consulta de funcionários do sistema a receberem aumento
	public static void ConsultarFuncionariosAumento(String[][] funcionarios, String [] cargos){
		
		String dados = "";
		
		// Busca todos os funcionários cadastrados na matriz (sistema)
		for (int i = 0; i < funcionarios.length; i ++){
			// Obtém os dados dos funcionários de acordo com a linha e coluna do registro do funcionário
			String nome = funcionarios[i][0];
			double salario = Double.parseDouble(funcionarios[i][1]);
			int cargo = Integer.parseInt(funcionarios[i][2]);
			
			// Desvia se o salário do funcionário não está entre R$ 1300 e R$ 3000
			if (salario < 1.300 || salario > 3.000) {
				break;
			}
			
			// É escolhida aleatoriamente a porcentagem de aumento do salário do funcionário
			// Para isso, é utilizado o método Math.random() multiplicado pelo intervalo de números desejado (Entre 10 e 15, portanto, o intervalo é 15)
			// Após, é somado com o valor mínimo (10), para indicar o início do intervalo
			// E ainda é somado com 1, para que o valor máximo (25) possa ser escolhido aleatoriamente também
			int porcentagem = (int) (10 + Math.random() * (25 - 10) + 1);
			
			double salarioAumento = salario + ((salario *  porcentagem)/100);
			
			// Obtém a descrição do cargo a partir do código do cargo gravado na matriz
			String descricaoCargo = cargos[cargo];
			
			// Utilizado (i + 1) para que o código seja iniciado em 1, pois em um vetor o primeiro índice é 0
			
			// Imprime as informações do funcionário no console
			
			dados = dados + "Código: " + (i + 1);
			dados = dados + "   Nome: " + nome;
			dados = dados + "   Cargo: " + descricaoCargo;
			dados = dados + "   Salário: " + salario;
			dados = dados + "   Salário com Aumento: " + salarioAumento;
			dados = dados + "\n";
			//JOptionPane.showMessageDialog(null, "Os dados da consulta encontram-se no console!");
		}
		
		if (dados == ""){
			JOptionPane.showMessageDialog(null, "Não há funcionários para receberem aumento!");
		}
		else{
			JOptionPane.showMessageDialog(null, dados);	
		}
		
	}
	
	// Método de inicialização da aplicação
	public static void main(String [] args){
		// Inicializa o vetor "cargos" com os cargos disponíveis
		String cargos[] =  {"Gerente","Desenvolvedor","Analista","Secretário"};
		
		// Realiza o cadastro dos usuários, obrigatoriamente, antes de disponibilizar o menu
		String[][] funcionarios = CadastrarFuncionarios();
		
		// Inicializa a variável "sair" para utilizar no loop de repetição do menu
		boolean sair = false;
		
		// Disponibiliza o menu ao usuário, para que o mesmo possa selecionar o que deseja executar
		do{
		
			// Opções do menu
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu:"
					+ "\n1 - Consulta de Funcionários"
					+ "\n2 - Consulta de Funcionários a receberem aumento"
					+ "\n3 - Sair"
					+ "\nInsira a opção desejada:"));
			
			// Opção: Consultar os funcionários do sistema
			if (opcao == 1){
				ConsultarFuncionarios(funcionarios, cargos);
			}
			// Opção: Consultar os funcionários do sistema que podem receber aumento
			else if (opcao == 2){
				ConsultarFuncionariosAumento(funcionarios, cargos);
			}
			// Opção: Sair do sistema
			else if (opcao == 3){
				sair = true;
			}
			// Caso o usuário digite uma opção não existente no menu, é informado à ele que a opção é inválida
			else{
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
			
		// O laço de repetição será executado enquanto a variável "sair" for falsa, ou seja, enquanto o usuário não clicar em sair
		} while (sair == false);
	}
	
}
