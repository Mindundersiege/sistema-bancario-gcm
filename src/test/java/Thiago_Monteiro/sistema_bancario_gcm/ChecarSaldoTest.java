package Thiago_Monteiro.sistema_bancario_gcm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import Thiago_Monteiro.sistema_bancario_gcm.command.ChecarSaldoCommand;
import Thiago_Monteiro.sistema_bancario_gcm.command.Command;

//import org.junit.Test;

@RunWith(Parameterized.class)
public class ChecarSaldoTest {

	@Parameters()
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
				{ 0, 1400.00 }, //
						{ 1, 6500.0 }, //
				});
	}

	@Parameter(0)
	public int id;

	@Parameter(1)
	public double expectedSaldo;

	@Test
	public void testRealizarDebito() {
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
		Command realizarSal = new ChecarSaldoCommand(sis, id);
		realizarSal.execute();
		assertThat((sis.getConta(id)).getSaldo(), is(equalTo(expectedSaldo)));
	}

}
