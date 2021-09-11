package br.com.alura.gerenciador.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println("Id selecionado:" + id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.encontraEmpresaId(id);
		
		if(empresa != null)
		{
			System.out.println("Empresa encontrada " + empresa.getNome());
			
			//configura informacoes para serem levadas com a requisicao 
			request.setAttribute("empresa", empresa);
			
			RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			System.out.println("Empresa não encontrada");
			response.sendRedirect("listaEmpresas");
		}
		
		
	}

}
