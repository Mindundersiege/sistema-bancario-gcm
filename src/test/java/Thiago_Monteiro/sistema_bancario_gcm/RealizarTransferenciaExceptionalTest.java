package Thiago_Monteiro.sistema_bancario_gcm;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import Thiago_Monteiro.sistema_bancario_gcm.command.Command;
import Thiago_Monteiro.sistema_bancario_gcm.command.RealizarTransferenciaCommand;
import Thiago_Monteiro.sistema_bancario_gcm.exception.ListaDeContasException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.TransferenciaException;

@RunWith(Parameterized.class)
public class RealizarTransferenciaExceptionalTest {

	@Parameters()
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
						{ 8, 1, 100.0, ListaDeContasException.class, "Conta 1 nao encontrada." },
						{ 1, 8, 100.0, ListaDeContasException.class, "Conta 2 nao encontrada." },//
						{ 1, 2, -1.0, TransferenciaException.class, "Valor negativo." },
						{ 0, 1, 1500.0, TransferenciaException.class, "Saldo insuficiente para transferencia." },//
				});
	}

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Parameter(0)
	public int id1;

	@Parameter(1)
	public int id2;

	@Parameter(2)
	public double valor;

	@Parameter(3)
	public Class<? extends Exception> expectedExceptionType;

	@Parameter(4)
	public String expectedErrorMessage;

	@Test
	public void testParseInvalidRank() {
		Conta.setNumeroDeContas(0);
		SistemaBancario sis = new SistemaBancario();
		Conta c1 = new Conta("Fernando Henrique", 1400.00);
		Conta c2 = new Conta("Luiz Inacio", 6500.000);
		Conta c3 = new Conta("Juscelino Kubitschek", 10650.00);
		Conta c4 = new Conta("Janio Quadros", 0.0);
		Conta c5 = new Conta("Itamar Franco", 100.0);
		Conta c6 = new Conta("Tancredo Neves", 10.0);
		sis.adicionarConta(c1);
		sis.adicionarConta(c2);
		sis.adicionarConta(c3);
		sis.adicionarConta(c4);
		sis.adicionarConta(c5);
		sis.adicionarConta(c6);

		e.expect(expectedExceptionType);
		e.expectMessage(expectedErrorMessage);

		Command realizarTra = new RealizarTransferenciaCommand(sis, id1, id2, valor);
		realizarTra.execute();
	}

}
