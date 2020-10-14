package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class CreditoException extends RuntimeException {

	private static final long serialVersionUID = 7339766740852413217L;

	public CreditoException(String errorMsg) {
		super(errorMsg);
	}
}
