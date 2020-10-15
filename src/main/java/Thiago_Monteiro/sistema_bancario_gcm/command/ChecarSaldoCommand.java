package Thiago_Monteiro.sistema_bancario_gcm.command;

import Thiago_Monteiro.sistema_bancario_gcm.SistemaBancario;

public class ChecarSaldoCommand implements Command {
	private final SistemaBancario sistema;
	private final int id;

	public ChecarSaldoCommand(SistemaBancario sistema, int id) {
		this.sistema = sistema;
		this.id = id;
	}

	@Override
	public void execute() {
		sistema.checarSaldo(id);

	}

}
