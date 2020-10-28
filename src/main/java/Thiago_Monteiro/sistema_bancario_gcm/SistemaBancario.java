package Thiago_Monteiro.sistema_bancario_gcm;

import java.util.ArrayList;

import Thiago_Monteiro.sistema_bancario_gcm.exception.CreditoException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.DebitoException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.ListaDeContasException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.TransferenciaException;

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

	public Conta getConta(int id) {
		boolean foundIt = false;
		for (Conta elem : contas) {
			if (elem.getId() == id) {
				foundIt = true;
				return elem;
			}
		}
		if (!foundIt) {
			throw new ListaDeContasException("Nao foi possivel encontrar a conta para ser removida.");
		}
		return null;
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

	public void checarSaldo(int idConta) {
		boolean foundIt = false;
		for (Conta elem : contas) {
			if (elem.getId() == idConta) {
				foundIt = true;
				System.out.println("O saldo da conta e: R$" + elem.getSaldo());
			}
		}
		if (!foundIt) {
			throw new ListaDeContasException("Conta nao encontrada.");
		}
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
				elem.setBonus(elem.getBonus() + (valor / 100));
			}
		}
		if (!foundIt) {
			throw new ListaDeContasException("Conta nao encontrada.");
		}
	}

	public void realizarDebito(int idConta, double valor) {
		if (valor < 0.0) {
			throw new DebitoException("Valor negativo.");
		}
		boolean foundIt = false;
		for (Conta elem : contas) {
			if (elem.getId() == idConta) {
				foundIt = true;
				if (elem.getSaldo() < valor) {
					throw new DebitoException("Valor maior do que saldo disponivel.");
				} else if (elem.getSaldo() >= valor) {
					elem.setSaldo((elem.getSaldo() - valor));
				}
			}
		}
		if (!foundIt) {

			throw new ListaDeContasException("Conta nao encontrada.");
		}
	}

	public void realizarTransferencia(int id1, int id2, double valor) {
		boolean foundIt1 = false;
		boolean foundIt2 = false;
		if (valor < 0) {
			throw new TransferenciaException("Valor negativo.");
		}
		for (Conta elem1 : contas) {
			if (elem1.getId() == id1) {
				foundIt1 = true;
				for (Conta elem2 : contas) {
					if (elem2.getId() == id2) {
						foundIt2 = true;
						if (elem1.getSaldo() < valor) {
							throw new TransferenciaException("Saldo insuficiente para transferencia.");
						} else if (elem1.getSaldo() >= valor) {
							elem1.setSaldo(elem1.getSaldo() - valor);
							elem2.setSaldo(elem2.getSaldo() + valor);
						}
					}
				}
			}
		}
		if (!foundIt1) {
			throw new ListaDeContasException("Conta 1 nao encontrada.");
		}
		if (!foundIt2) {
			throw new ListaDeContasException("Conta 2 nao encontrada.");
		}
	}
}
