package Thiago_Monteiro.sistema_bancario_gcm;

import java.util.ArrayList;

public class SistemaBancario {
	private final ArrayList<Conta> contas = new ArrayList<>();

	public void mostrarContas() {
		System.out.println("Contas disponiveis: ");
		for (Conta elem : contas) {
			elem.mostrarConta();
		}
	}

	public void removerConta(int id) {
		int size = contas.size();
		for (Conta elem : contas) {
			if (elem.getId() == id) {
				contas.remove(elem);
			}
		}
		if (size == contas.size()) {
			// exception
		}
	}

	public void adicionarConta(Conta conta) {
		boolean addIt = true;
		if (conta != null) {
			for (Conta elem : contas) {
				if (conta.getId() == elem.getId()) {
					addIt = false;
				}
			}
			if (addIt) {
				contas.add(conta);
			}
			if (!addIt) {
				// exception
			}
		}
	}

	public void checarSaldo() {

	}

	public void realizarCredito() {

	}

	public void realizarDebito() {

	}

	public void realizarTransferencia() {

	}
}
