package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("date");
		Integer id = Integer.valueOf(request.getParameter("id"));
		Date dataAlterada = null;
		
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			dataAlterada = formatDate.parse(dataEmpresa);
		} catch (ParseException e) {
			// Capturou e joga a excessão 
			throw new ServletException(e);
		}
		
		System.out.println("Id a ser alterado: " + id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.encontraEmpresaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAlterada);
		
		response.sendRedirect("listaEmpresas");
	}

}
