package Thiago_Monteiro.sistema_bancario_gcm;

import java.util.ArrayList;

import Thiago_Monteiro.sistema_bancario_gcm.exception.CreditoException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.DebitoException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.ListaDeContasException;

public class SistemaBancario {
	private final ArrayList<Conta> contas = new ArrayList<>();

	public void mostrarContas() {
		if (contas == null || contas.isEmpty()) {
			throw new ListaDeContasException("Lista vazia.");
		}
		System.out.println("Contas disponiveis: ");
		for (Conta elem : contas) {
			elem.mostrarConta();
		}
	}

	public void removerConta(int id) {
		boolean foundIt = false;
		for (Conta elem : contas) {
			if (elem.getId() == id) {
				contas.remove(elem);
				foundIt = true;
			}
		}
		if (!foundIt) {
			throw new ListaDeContasException("Nao foi possivel encontrar a conta para ser removida.");
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
			} else if (!addIt) {
				throw new ListaDeContasException("Esta conta ja existe no sistema.");
			}
		}
	}

	public void checarSaldo() {

	}

	public void realizarCredito(int idConta, double valor) {
		if (valor < 0) {
			throw new CreditoException("Valor negativo.");
		}
		boolean foundIt = false;
		for (Conta elem : contas) {
			if (elem.getId() == idConta) {
				foundIt = true;
				elem.setSaldoCredito((elem.getSaldoCredito() + valor));
			}
		}
		if (!foundIt) {
			throw new ListaDeContasException("Conta nao encontrada.");
		}
	}

	public void realizarDebito(int idConta, double valor) {
		if (valor < 0) {
			throw new DebitoException("Valor negativo.");
		}
		boolean foundIt = false;
		for (Conta elem : contas) {
			if (elem.getId() == idConta) {
				foundIt = true;
				if (elem.getSaldo() >= valor) {
					elem.setSaldo((elem.getSaldo() - valor));
				} else if (elem.getSaldo() < valor) {
					throw new DebitoException("Valor maior do que saldo disponivel.");
				}
			}
		}
		if (!foundIt) {
			throw new ListaDeContasException("Conta nao encontrada.");
		}
	}

	public void realizarTransferencia() {

	}
}
