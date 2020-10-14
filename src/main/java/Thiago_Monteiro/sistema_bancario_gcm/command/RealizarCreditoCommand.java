package Thiago_Monteiro.sistema_bancario_gcm.command;

import Thiago_Monteiro.sistema_bancario_gcm.SistemaBancario;

public class RealizarCreditoCommand implements Command {
	private final SistemaBancario sistema;

	public RealizarCreditoCommand(SistemaBancario sistema) {
		this.sistema = sistema;
	}

	@Override
	public void execute() {
		sistema.realizarCredito();

	}

}
