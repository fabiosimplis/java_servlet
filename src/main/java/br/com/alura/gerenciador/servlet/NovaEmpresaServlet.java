package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Da suporte somente ao Post, se quiser somente get use doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("date");
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = formatDate.parse(dataEmpresa);
		} catch (ParseException e) {
			// Capturou e joga a excessão 
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		System.out.print("Cadastrando nova empresa: "+ nomeEmpresa +"\n");
		/*
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa "+ nomeEmpresa + " cadastrada com sucesso!</body></html>");
		*/
		
		request.setAttribute("empresa", empresa.getNome());
		//redireciona para outra pagina
		response.sendRedirect("listaEmpresas");
		/*
		// chamar o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response);
		*/
	}

}
