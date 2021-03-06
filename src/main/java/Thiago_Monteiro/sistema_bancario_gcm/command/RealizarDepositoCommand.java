package Thiago_Monteiro.sistema_bancario_gcm.command;

import Thiago_Monteiro.sistema_bancario_gcm.SistemaBancario;

public class RealizarDepositoCommand implements Command {
	private final SistemaBancario sistema;
	private final int id;
	private final double valor;

	public RealizarDepositoCommand(SistemaBancario sistema, int id, double valor) {
		this.sistema = sistema;
		this.id = id;
		this.valor = valor;
	}

	@Override
	public void execute() {
		sistema.realizarDeposito(id, valor);

	}

}
