package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class TransferenciaException extends RuntimeException {

	private static final long serialVersionUID = 5478841122585412536L;

	public TransferenciaException(String errorMsg) {
		super(errorMsg);
	}
}
