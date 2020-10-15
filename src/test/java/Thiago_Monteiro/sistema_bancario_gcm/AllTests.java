package Thiago_Monteiro.sistema_bancario_gcm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { RealizarDebitoExceptionalTest.class, RealizarCreditoExceptionalTest.class,
		RealizarCreditoTest.class, RealizarDebitoTest.class, RealizarTransferenciaTest.class,
		RealizarTransferenciaExceptionalTest.class, ChecarSaldoTest.class, ChecarSaldoExceptionalTest.class })
public class AllTests {

}
