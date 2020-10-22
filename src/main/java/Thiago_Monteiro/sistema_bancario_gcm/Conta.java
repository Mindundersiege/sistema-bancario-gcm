package Thiago_Monteiro.sistema_bancario_gcm;

public class Conta {
	private String nomeUsuario;
	private double saldo;
	private double saldoCredito;
	private static int numeroDeContas = 0;
	private int id = 0;

	// Para testes apenas
	public static void setNumeroDeContas(int n) {
		numeroDeContas = n;
	}

	public Conta() {
		id = numeroDeContas++;
		this.nomeUsuario = "";
		this.saldo = 0.0;
		this.saldoCredito = 0.0;
	}

	public Conta(String nome, double saldo) {
		this.nomeUsuario = nome;
		this.saldo = saldo;
		id = numeroDeContas++;
		this.saldoCredito = 0.0;
	}

	@Override
	protected void finalize() {
		numeroDeContas--;
	}

	public void mostrarConta() {
		System.out.println("Nome do usuario: " + nomeUsuario);
		// System.out.println("Saldo da Conta: R$" + saldo);
		System.out.println("id da Conta: " + id);
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public double getSaldoCredito() {
		return saldoCredito;
	}

	public void setSaldoCredito(double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}
}
