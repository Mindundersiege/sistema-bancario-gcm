package Thiago_Monteiro.sistema_bancario_gcm.exception;

public class ListaDeContasException extends RuntimeException {

	private static final long serialVersionUID = 5928242304622358265L;

	public ListaDeContasException(String errorMsg) {
		super(errorMsg);
	}
}
