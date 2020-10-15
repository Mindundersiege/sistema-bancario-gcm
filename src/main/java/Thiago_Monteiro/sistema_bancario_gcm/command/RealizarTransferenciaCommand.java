package Thiago_Monteiro.sistema_bancario_gcm.command;

import Thiago_Monteiro.sistema_bancario_gcm.SistemaBancario;

public class RealizarTransferenciaCommand implements Command {
	private final SistemaBancario sistema;
	private final int id1;
	private final int id2;
	private final double valor;

	public RealizarTransferenciaCommand(SistemaBancario sistema, int id1, int id2, double valor) {
		this.sistema = sistema;
		this.id1 = id1;
		this.id2 = id2;
		this.valor = valor;
	}

	@Override
	public void execute() {
		sistema.realizarTransferencia(id1, id2, valor);

	}
}
