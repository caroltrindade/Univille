package gerenciar;

import javax.swing.JOptionPane;

/*
Sistema de gerenciamento de funcion�rios de uma empresa de software
Ser� criado um sistema de gerenciamento de funcion�rios de uma empresa de software.
A empresa possuir� 10 funcion�rios, os quais ser�o cadastrados pelo usu�rio do sistema.
Cada usu�rio ter� c�digo, nome, sal�rio e cargo (Gerente, desenvolvedor, analista e secret�rio).
Ser� disponibilizado uma consulta dos funcion�rios da empresa e seus sal�rios.
Ser� disponibilizado uma consulta dos funcion�rios a receberem aumento. Restri��es:
O funcion�rio deve possuir um sal�rio superior a R$ 1300,00 e inferior a R$ 3000,00;
O aumento deve ser distribu�do randomicamente, isto �, de forma aleat�ria, onde a porcentagem de aumento sobre sal�rio atual deve variar entre 10% e 25%.
 
 */

public class Funcionarios {

	// M�todo para realizar o cadastro de funcion�rios do sistema
	public static String[][] CadastrarFuncionarios(){
		// Inicializa a matriz de funcion�rios, com 10 linhas e 3 colunas
		String funcionarios[][] = new String[10][3];
		
		// Solicita a defini��o dos funcion�rios para o usu�rio que est� operando do sistema
		for (int i = 0; i < 10; i++){
			
			// Utilizado (i + 1) para que o c�digo seja iniciado em 1, pois em um vetor o primeiro �ndice � 0
			
			// Solicita o nome do funcion�rio
			String nome = JOptionPane.showInputDialog("Insira o nome do funcion�rio " + (i + 1));
			
			// Solicita o sal�rio do funcion�rio
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o sal�rio do funcion�rio " + (i + 1)));
			
			// As vari�ves s�o instanciadas antes do while, pois sen�o elas ser�o acess�veis apenas dentro do while
			boolean valido = false;
			int cargo = 0;
			
			while(!valido) {
				// Solicita o cargo do funcion�rio
				cargo = Integer.parseInt(JOptionPane.showInputDialog("Insira o cargo do funcion�rio "  + (i + 1) + " (1 - Gerente, 2 - Desenvolvedor, 3 - Analista, 4 - Secret�rio)"));
				
				// Verifica se o usu�rio inseriu uma op��o v�lida para o cargo do funcion�rio
				// Se for inv�lida, � necess�rio informar novamente
				if (cargo != 1 && cargo != 2 && cargo != 3 && cargo != 4)  {
					JOptionPane.showMessageDialog(null, "Valor inv�lido! Favor preencher corretamente o campo.");
				}
				// Se for v�lida, � dado sequ�ncia para a pr�xima informa��o
				else{
					valido = true;
				}
			}	
			
			// Converte o c�digo do cargo do funcion�rio digitado para o �ndice do vetor, que se inicia em 0, e n 
			cargo = cargo - 1;
			
			// Grava os dados do funcion�rio na matriz
			
			// O c�digo do funcion�rio � a sequ�ncia que o mesmo foi inserido (i)
			funcionarios[i][0] = nome;
			
			// Como o tipo de dado da matriz � String, � necess�rio converter o sal�rio e o cargo, do tipo de dado double e int, respectivamente, para String
			funcionarios[i][1] = String.valueOf(salario); 
			funcionarios[i][2] = String.valueOf(cargo);
		}
		// Retorna a matriz de funcion�rios, j� preenchida
		return funcionarios;
	}
	
	// M�todo para realizar a consulta de funcion�rios do sistema
	public static void ConsultarFuncionarios(String[][] funcionarios, String [] cargos){
		
		String dados = "";
		
		// Busca todos os funcion�rios cadastrados na matriz (sistema)
		for (int i = 0; i < funcionarios.length; i ++){
			
			// Obt�m os dados dos funcion�rios de acordo com a linha e coluna do registro do funcion�rio
			String nome = funcionarios[i][0];
			double salario = Double.parseDouble(funcionarios[i][1]);
			int cargo = Integer.parseInt(funcionarios[i][2]);
			
			// Obt�m a descri��o do cargo a partir do c�digo do cargo gravado na matriz
			String descricaoCargo = cargos[cargo];
			
			// Utilizado (i + 1) para que o c�digo seja iniciado em 1, pois em um vetor o primeiro �ndice � 0
			
			// Imprime as informa��es do funcion�rio no console
			dados = dados + "C�digo: " + (i + 1);
			dados = dados + "   Nome: " + nome;
			dados = dados + "   Cargo: " + descricaoCargo;
			dados = dados + "   Sal�rio: " + salario;
			dados = dados + "\n";
		}
		
		JOptionPane.showMessageDialog(null, dados);
		
	}
	
	// M�todo para realizar a consulta de funcion�rios do sistema a receberem aumento
	public static void ConsultarFuncionariosAumento(String[][] funcionarios, String [] cargos){
		
		String dados = "";
		
		// Busca todos os funcion�rios cadastrados na matriz (sistema)
		for (int i = 0; i < funcionarios.length; i ++){
			// Obt�m os dados dos funcion�rios de acordo com a linha e coluna do registro do funcion�rio
			String nome = funcionarios[i][0];
			double salario = Double.parseDouble(funcionarios[i][1]);
			int cargo = Integer.parseInt(funcionarios[i][2]);
			
			// Desvia se o sal�rio do funcion�rio n�o est� entre R$ 1300 e R$ 3000
			if (salario < 1.300 || salario > 3.000) {
				break;
			}
			
			// � escolhida aleatoriamente a porcentagem de aumento do sal�rio do funcion�rio
			// Para isso, � utilizado o m�todo Math.random() multiplicado pelo intervalo de n�meros desejado (Entre 10 e 15, portanto, o intervalo � 15)
			// Ap�s, � somado com o valor m�nimo (10), para indicar o in�cio do intervalo
			// E ainda � somado com 1, para que o valor m�ximo (25) possa ser escolhido aleatoriamente tamb�m
			int porcentagem = (int) (10 + Math.random() * (25 - 10) + 1);
			
			double salarioAumento = salario + ((salario *  porcentagem)/100);
			
			// Obt�m a descri��o do cargo a partir do c�digo do cargo gravado na matriz
			String descricaoCargo = cargos[cargo];
			
			// Utilizado (i + 1) para que o c�digo seja iniciado em 1, pois em um vetor o primeiro �ndice � 0
			
			// Imprime as informa��es do funcion�rio no console
			
			dados = dados + "C�digo: " + (i + 1);
			dados = dados + "   Nome: " + nome;
			dados = dados + "   Cargo: " + descricaoCargo;
			dados = dados + "   Sal�rio: " + salario;
			dados = dados + "   Sal�rio com Aumento: " + salarioAumento;
			dados = dados + "\n";
			//JOptionPane.showMessageDialog(null, "Os dados da consulta encontram-se no console!");
		}
		
		if (dados == ""){
			JOptionPane.showMessageDialog(null, "N�o h� funcion�rios para receberem aumento!");
		}
		else{
			JOptionPane.showMessageDialog(null, dados);	
		}
		
	}
	
	// M�todo de inicializa��o da aplica��o
	public static void main(String [] args){
		// Inicializa o vetor "cargos" com os cargos dispon�veis
		String cargos[] =  {"Gerente","Desenvolvedor","Analista","Secret�rio"};
		
		// Realiza o cadastro dos usu�rios, obrigatoriamente, antes de disponibilizar o menu
		String[][] funcionarios = CadastrarFuncionarios();
		
		// Inicializa a vari�vel "sair" para utilizar no loop de repeti��o do menu
		boolean sair = false;
		
		// Disponibiliza o menu ao usu�rio, para que o mesmo possa selecionar o que deseja executar
		do{
		
			// Op��es do menu
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu:"
					+ "\n1 - Consulta de Funcion�rios"
					+ "\n2 - Consulta de Funcion�rios a receberem aumento"
					+ "\n3 - Sair"
					+ "\nInsira a op��o desejada:"));
			
			// Op��o: Consultar os funcion�rios do sistema
			if (opcao == 1){
				ConsultarFuncionarios(funcionarios, cargos);
			}
			// Op��o: Consultar os funcion�rios do sistema que podem receber aumento
			else if (opcao == 2){
				ConsultarFuncionariosAumento(funcionarios, cargos);
			}
			// Op��o: Sair do sistema
			else if (opcao == 3){
				sair = true;
			}
			// Caso o usu�rio digite uma op��o n�o existente no menu, � informado � ele que a op��o � inv�lida
			else{
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			}
			
		// O la�o de repeti��o ser� executado enquanto a vari�vel "sair" for falsa, ou seja, enquanto o usu�rio n�o clicar em sair
		} while (sair == false);
	}
	
}
