package br.com.alura.gerenciador.servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 0;
	
	// bloco estaticos
	static {
		
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		empresa.setDataAbertura(new Date());
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(new Date());
		
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		boolean isRemove = false;
		
		Iterator<Empresa> it = lista.iterator();
		
		
		while(it.hasNext())
		{
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
				isRemove = true;
			}
			
		}
		
		if(isRemove)
			System.out.println("Empresa Removida");
		else
			System.out.println("Empresa não encontrada " + id);
		
	}

	public Empresa encontraEmpresaId(Integer id) {
		
		for (Empresa empresa : lista) {
			
			if(empresa.getId() == id)
				return empresa;
			
		}
		
		return null;
	}

}
