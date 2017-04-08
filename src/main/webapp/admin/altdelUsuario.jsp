<%-- 
    Document   : altdelUsuario
    Created on : Apr 2, 2017, 2:50:43 PM
    Author     : vitor
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area Restrita</title>
    </head>
    <body>
        <h1>Area de Acesso restrito aos administrtadores</h1>
        <h2>Alteraçao e Exclusao de usuario</h2>
        
        <% 
          String msg = (String) request.getAttribute("msg");
          if(msg != null){
        %>
        <font color="blue"><%=msg %></font>
        <%}%>
        <form action="../UsuarioController" method="POST">
            Login: <input type="text" name="txtLogin"></br>
            <input type="submit" value="Localizar" name="acao"></br>
            Nome: <input type="text" value="<%=request.getParameter("nome")%>" name="txtNome"></br>
            Sobrenome: <input type="text" name="txtSobrenome"></br>
            Email: <input type="text" name="txtEmail"></br>
            Senha: <input type="password" name="txtSenha"></br>
            Cargo: <select name="optCargo">
                <option>GERENTE</option>
                <option>SECRETARIA</option>
                <option>ESTOQUISTA</option>
            </select><br/>
            RG: <input type="text" name="txtRg"></br>
            CPF: <input type="text" name="txtCpf"></br>
            Endereço: <input type="text" name="txtEndereco"></br>
            Perfil: <select name="optPerfil">
                <option>COMUM </option>
                <option>ADMINISTRADOR</option>
            </select><br/>
            <input type="submit" value="Excluir" name="acao">
            <input type="submit" value="Alterar" name="acao"></br>
        </form>
        <a href="../principal.jsp">Página Principal</a>
    </body>
</html>
