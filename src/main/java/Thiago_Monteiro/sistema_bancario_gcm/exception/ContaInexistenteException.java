package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class ContaInexistenteException extends RuntimeException {

	private static final long serialVersionUID = -9203465689956897759L;

	public ContaInexistenteException(String errorMsg) {
		super(errorMsg);
	}

}
