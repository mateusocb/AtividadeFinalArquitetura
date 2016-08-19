<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, br.ifrn.meutcc.modelo.Tema" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu TCC</title>
</head>
<body>

<%
	boolean verificar=false;
	if(request.getAttribute("solicitacao")!=null){
		out.println("<h1>Listagem dos Temas referentes ao Orientador</h1>");
		verificar=(boolean)request.getAttribute("solicitacao");
	}else{
		out.println("<h1>Listagem dos Temas Disponíveis para TCC</h1>");
	}
	out.println("<ol>");
	List<Tema> temas = (List<Tema>) request.getAttribute("temas");
	if (temas != null && !temas.isEmpty()) {
		for(Tema t: temas) {
			if(verificar==false){
				out.println("<li><a href=\"/MeuTCC/ViewTema?id="+t.getId()+
							"\">["+t.getId()+"] "+t.getTitulo()+"</a>.</li>");
			}else{
				out.println("<li><a href=\"/MeuTCC/ViewTemaSolicitacoes?id="+t.getId()+
						"\">["+t.getId()+"] "+t.getTitulo()+"</a>.</li>");
			}
		}
	} else {
		out.println("<li>Nenhum tema cadastrado para o referido curso!</li>");
	}
	out.println("</ol>");
%>
</body>
</html>