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
import Thiago_Monteiro.sistema_bancario_gcm.command.RealizarCreditoCommand;
import Thiago_Monteiro.sistema_bancario_gcm.exception.CreditoException;
import Thiago_Monteiro.sistema_bancario_gcm.exception.ListaDeContasException;

@RunWith(Parameterized.class)
public class RealizarCreditoExceptionalTest {

	@Parameters()
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
				{ 8, 100.0, ListaDeContasException.class, "Conta nao encontrada." }, //
						{ 1, -1.0, CreditoException.class, "Valor negativo." }, //
				});
	}

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Parameter(0)
	public int id;

	@Parameter(1)
	public double valor;

	@Parameter(2)
	public Class<? extends Exception> expectedExceptionType;

	@Parameter(3)
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

		Command realizarCre = new RealizarCreditoCommand(sis, id, valor);
		realizarCre.execute();
	}

}
