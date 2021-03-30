<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("agenda");

// TESTE PARA EXIBIÇÃO DA LISTA DE AGENDA
/* for (int i = 0; i < lista.size(); i++ ) {
	
	out.println(lista.get(i).getIdcon());
	out.println(lista.get(i).getEmail());
	out.println(lista.get(i).getFone());
	out.println(lista.get(i).getNome());
    
} */
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel = "stylesheet" href ="style.css">
</head>
<body id="meio">
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo Contato</a>

	<table id="tabela" align = "center"> <br><br><br><br><br>
	
		<thead>
			<tr>
				<th><h2>ID</h2></th>
				<th><h2>NOME</h2></th>
				<th><h2>TELEFONE</h2></th>
				<th><h2>E-MAIL</h2></th>
				<th><h2>OPÇÕES</h2></th>
			</tr>
		<tbody>


			<%
			for (int i = 0; i < lista.size(); i++) {
			%>

			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td> 
				<td><a href="select?idcon<%=lista.get(i).getIdcon()%>" class="botao1">EDITAR</a></td>
				
			</tr>

			<%
			}
			%>

		</tbody>
		</thead>
	</table>


</body>
</html>