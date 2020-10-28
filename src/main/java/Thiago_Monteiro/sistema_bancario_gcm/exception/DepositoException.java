package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class DepositoException extends RuntimeException {

	private static final long serialVersionUID = 7339766740852413217L;

	public DepositoException(String errorMsg) {
		super(errorMsg);
	}
}
