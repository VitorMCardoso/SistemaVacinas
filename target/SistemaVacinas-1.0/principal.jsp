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
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

            if (usuario != null) {
        %>
        <title>Bem Vindo, <%= usuario.getNome()%> !</title>
    </head>
    <body>
        
        <div align="center">
        <h1>Menu de Opçoes</h1>
       
        <%}%>
        <p><a href="new"><button>Cadastro de Usuario</button></a></p>
        <p><a href="list"><button>Manter Usuarios</button></a></p>
        
        <p><a href="newPaciente"><button>Cadastro de Paciente</button></a></p>
        <p><a href="listPaciente"><button>Manter Paciente</button></a></p>
        </div>
    </body>
</html>
