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
</head>
<body id="meio">
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo Contato</a>

	<table id="tabela" align="center"> <br><br><br><br><br>
	
		<thead>
			<tr>
				<th><h2>ID</h2></th>
				<th><h2>NOME</h2></th>
				<th><h2>TELEFONE</h2></th>
				<th><h2>E-MAIL</h2></th>
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
			</tr>

			<%
			}
			%>

		</tbody>
		</thead>
	</table>

	<style>
@import
	url('https://fonts.googleapis.com/css2?family=Crete+Round&display=swap')
	;

body {
	font-family: 'Crete Round', serif;
	font-size: 1em;
	font-weight: 400;
	display: flex;
}

h1 {
	color: #2c53de;
}

#meio {
	background-size: 100%;
	background-image: url("imagens/Fundo-Site.jpg");
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: auto;
}

.botao1 {
	text-decoration: none;
	background: #66bbff;
	padding: 5px 10px 5px 10px;
	font-size: 1.2em;
	font-weight: 700;
	border-radius: 5px; tabela { margin-top : 80px;
	border-radius: 5px;
	text-align: center;
}

.th {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: center;
	background: #66bbff;
	color: #fff;
}

#tabela {
margin-top: 30px;


}
</style>
</body>
</html>