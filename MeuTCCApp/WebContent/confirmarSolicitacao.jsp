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
	boolean result =  (boolean) request.getAttribute("result");

	if (result) {
		out.println("<h1> Orienta��o criada com sucesso!</h1>");
	} else {
		out.println("<h1>Limite de solicita��es ultrapassado!</h1>");
		out.println("<p>Espere at� a confirma��o do seu coordenador...</p>");
	}
	
%>
	<a href="/MeuTCC/ListTemas">Voltar</a>
</body>
</html>