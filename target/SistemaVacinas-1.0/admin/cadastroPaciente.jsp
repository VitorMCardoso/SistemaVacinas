<%-- 
    Document   : cadastroPaciente
    Created on : Apr 7, 2017, 2:41:13 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <title>Area Restrita</title>
    </head>
    <body>
        <h1>Area de Acesso restrito aos administrtadores</h1>
        <h2>Cadastro de novo paciente</h2>
        
        <% 
          String msg = (String) request.getAttribute("msg");
          if(msg != null){
        %>
        <font color="blue"><%=msg %></font>
        <%}%>
        <form action="../PacientesController" method="POST">
            Nome: <input type="text" name="txtNome"></br>
            Sobrenome: <input type="text" name="txtSobrenome"></br>
            Login: <input type="text" name="txtLogin"></br>
            Email: <input type="text" name="txtEmail"></br>
            Senha: <input type="password" name="txtSenha"></br>
            RG: <input type="text" name="txtRg"></br>
            CPF: <input type="text" name="txtCpf"></br>
            Endereço: <input type="text" name="txtEndereco"></br>
            <input type="submit" value="Cadastrar" name="acao">
        </form>
        <a href="../principal.jsp">Página Principal</a>
    </body>
</html>
