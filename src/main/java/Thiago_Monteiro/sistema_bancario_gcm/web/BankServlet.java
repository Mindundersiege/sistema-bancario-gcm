package Thiago_Monteiro.sistema_bancario_gcm.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Thiago_Monteiro.sistema_bancario_gcm.SistemaBancario;

public class BankServlet extends HttpServlet {
	private final SistemaBancario sis = new SistemaBancario();

	// ENVIA INFORMACOES
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

	// MODIFICA/CRIA ALGUMA COISA
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

}
