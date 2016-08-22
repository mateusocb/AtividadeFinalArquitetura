<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, br.ifrn.meutcc.modelo.Tema, br.ifrn.meutcc.modelo.Candidato"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu TCC</title>
</head>
<body>
<h1>Detalhes do Tema</h1>
<%
	Tema tema = (Tema) request.getAttribute("tema");
	List<Candidato> candidatos = (List<Candidato>) request.getAttribute("candidatos");
	
	if (tema != null) {
		out.println("<h3>"+tema.getTitulo()+"</h3>");
		out.println("<ul>");
		out.println("<li> ID = "+tema.getId()+"</li>");
		out.println("<li> Descrição = "+tema.getDescricao()+"</li>");
		out.println("</ul>");
	} else {
		out.println("<h3>Não há nenhum tema para mostrar!</h3>");
	}
	out.println(candidatos);
	if (candidatos != null && !candidatos.isEmpty()) {
		out.println("<form ACTION=\"/MeuTCC/ConfirmarSolicitacao\" method=\"post\">");
		for(Candidato c: candidatos) {
			out.println("<input type=\"checkbox\" name=\"candidato\" value=\""+ c.getId()+ "\">"+ c.getNome()+ "<BR>");
		}
		out.println("<input hidden type=\"checkbox\" name=\"tema\" value=\""+ tema.getId()+ "\"checked >");
		out.println("<input type=\"submit\" value=\"Aceitar\">");
		out.println("</form>");
	} else {
		out.println("<li>Nenhum candidato cadastrado ao curso!</li>");
	}
%>
</body>
</html>