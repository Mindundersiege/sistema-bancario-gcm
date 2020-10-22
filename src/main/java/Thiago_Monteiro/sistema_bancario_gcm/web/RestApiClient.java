package Thiago_Monteiro.sistema_bancario_gcm.web;

import java.io.IOException;
import java.util.Scanner;

public class RestApiClient {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem vindo(a) ao sistema bancario.");
		System.out.println("Para adicionar uma nova conta, escreva 'add'.");
		System.out.println("Para remover uma conta, escreva 'rem'.");
		System.out.println("Para realizar debito, escreva 'deb'.");
		System.out.println("Para realizar credito, escreva 'cre'.");
		System.out.println("Para realizar transferencia, escreva 'tra'.");
		String input = scanner.nextLine();
		if ("add".equalsIgnoreCase(input)) {

			System.out.println("Digite o nome da pessoa a ser adicionada.");
			String nome = scanner.nextLine();
			System.out.println("Digite o saldo da pessoa a ser adicionada.");
			String saldo = scanner.nextLine();

			adicionarConta(nome, saldo);
		} else if ("rem".equalsIgnoreCase(input)) {
		} else if ("deb".equalsIgnoreCase(input)) {
		} else if ("cre".equalsIgnoreCase(input)) {
		} else if ("tra".equalsIgnoreCase(input)) {
		}

		scanner.close();

		System.out.println("Obrigado por utilizar o sistema de bancos.");

	}

	public static void adicionarConta(String nome, String saldo) throws IOException {
	}

	public static void removerConta(String name) throws IOException {
	}

	public static void realizarDebito(String nome, String valor) throws IOException {
	}

	public static void realizarCredito(String nome, String valor) throws IOException {
	}

	public static void realizarTransferencia(String nome1, String nome2, String valor) throws IOException {
	}
}