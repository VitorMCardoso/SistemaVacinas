<%-- 
    Document   : index
    Created on : Mar 5, 2017, 5:53:44 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>

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
                <button class="btn waves-effect waves-light" type="submit" name="acao" value="Entrar">Entrar</button>
            </form>
        </div>
    </body>
</html>
