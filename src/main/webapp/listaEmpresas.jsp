<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib 	uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib 	uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/removeEmpresa" var="linkServletRemove"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Empresas</title>
</head>
<body>
	
	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	
	Lista de Empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa"> 
			<li>
			${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="/gerenciador/mostraEmpresa?id=${empresa.id}">Editar</a>
			<a href="${linkServletRemove}?id=${empresa.id}">Remove</a>
			
			</li> 
		</c:forEach>
	</ul>

	
</body>
</html>