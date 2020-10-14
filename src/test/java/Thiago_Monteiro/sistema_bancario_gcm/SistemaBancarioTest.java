package Thiago_Monteiro.sistema_bancario_gcm;

//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

//import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

//import org.junit.Test;

@RunWith(Parameterized.class)
public class SistemaBancarioTest {

	@Parameters()
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
				{ "Fernando Henrique", 400.00 }, //
						{ "Luiz Inacio", 7, 10000.000 }, //
						{ "Juscelino Kubitschek", 650.00 }, //
						{ "Janio Quadros", 0.0 }, //
						{ "Itamar Franco", -1.0 }, //
						{ "Tancredo Neves", 10.0 },//
				});
	}

	@Parameter(0)
	public String nomeConta;

	@Parameter(1)
	public double saldoConta;
	/*
	 * @Test public void testSistemaBancario() { final Card card =
	 * ParseStringService.parseToCard(input);
	 * 
	 * assertThat(card.getRank(), is(equalTo(expectedRank)));
	 * assertThat(card.getSuit(), is(equalTo(expectedSuit))); }
	 */

}
