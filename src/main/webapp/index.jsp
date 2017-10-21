<%-- 
    Document   : index
    Created on : Mar 5, 2017, 5:53:44 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Autenticação</title>
    </head>
    <body>
        <div class="container" align="center">
            <h2>Autenticação de Usuário!</h2><br>
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
            %>
            <font color="red"> <%=msg%></font>
            <%}%>
            <br>
            <form action="AcessoController" method="POST">
                <input placeholder="Login" name="txtLogin" type="text" class="validate">
                <br>
                <input placeholder="Senha" name="txtSenha" type="password" class="validate">
                <br>
                <button class="btn btn-default" type="submit" name="acao" value="Entrar">Entrar</button>
            </form>
        </div>
    </body>
</html>
