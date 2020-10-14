package Thiago_Monteiro.sistema_bancario_gcm.command;

import Thiago_Monteiro.sistema_bancario_gcm.SistemaBancario;


public class ChecarSaldoCommand implements Command {
	private final SistemaBancario sistema;

	public ChecarSaldoCommand(SistemaBancario sistema) {
		this.sistema = sistema;
	}

	@Override
	public void execute() {
		sistema.checarSaldo();

	}

}
