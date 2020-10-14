package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class DebitoException extends RuntimeException {

	private static final long serialVersionUID = -753267080336614061L;

	public DebitoException(String errorMsg) {
		super(errorMsg);
	}
}
