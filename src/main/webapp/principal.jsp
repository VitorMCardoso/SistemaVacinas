<%-- 
    Document   : principal
    Created on : Mar 5, 2017, 7:18:22 PM
    Author     : vitor
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

            if (usuario != null) {
        %>
        <h1>Bem Vindo, <%= usuario.getNome()%> !</h1>
       
        <%}%>
        <a href="admin/cadastro_usuario.jsp">Area Restrita</a><br/>
        <a href="admin/listarUsuario">Listar Usuarios</a><br/>
        <a href="AcessoController?acao=Sair">Logout</a>
    </body>
</html>
