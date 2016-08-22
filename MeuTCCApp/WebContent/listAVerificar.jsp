<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, br.ifrn.meutcc.modelo.Tema" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu TCC</title>
</head>
<body>

<h1>Lista de Solicitacoes a serem avaliadas.</h1>
<form method="POST" action="/MeuTCC/ListAVerificar">
<%
	Tema tema = new Tema();
	List<Tema> temasAVerificar = tema.getTemasAVerificar(1);
	
	if(temasAVerificar.isEmpty()) {
		out.println("Não há solicitações a serem avaliadas.");
	} else{
		out.println("<table border=0>");		
		out.println("<tr>");
		out.println("<td>Tema</td>");
		out.println("<td>Orientador</td>");
		out.println("<td>Candidato</td>");
		out.println("</tr>");
		for(Tema t: temasAVerificar) {
			out.println("<td>" + t.getTitulo() + "</td>");
			out.println("<td>" + t.getOrientador().getNome() + "</td>");
			out.println("<td>" + t.getCandidato().getNome() + "</td>");
			out.println("<td> <button name=\"situacao\" type=\"submit\" value= \"" + t.getId() + "A\">Aceitar</button></td>");
			out.println("<td> <button name=\"situacao\" type=\"submit\" value= \"" + t.getId() + "R\">Recusar</button></td>");
		}
	}
%>
</table>
</form>
</body>
</html>