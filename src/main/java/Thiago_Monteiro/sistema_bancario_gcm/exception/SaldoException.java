package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class SaldoException extends RuntimeException {

	private static final long serialVersionUID = 7299633417191572753L;

	public SaldoException(String errorMsg) {
		super(errorMsg);
	}
}
