<%-- 
    Document   : listarUsuario
    Created on : Apr 7, 2017, 11:36:59 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Show All Users</title>
    </head>
    <body>
        <center>
                    
                    <h3>
                            <a href="new">Adicionar Novo Usuario</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="list">List All Usuario</a>
                             
                        </h3>
                </center>
        <table border=1>

            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>Login</th>
                <th>Email</th>
                <th>Cargo</th>
                <th>RG</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>Ativo</th>
                <th>Perfil</th>
                <th colspan=2>Açao</th>
            </tr>


            <c:forEach var="usuario" items="${listarUsuario}" >
                <tr>

                    <td><c:out value="${usuario.id}" /></td>
                    <td><c:out value="${usuario.nome}" /></td>
                    <td><c:out value="${usuario.sobrenome}" /></td>
                    <td><c:out value="${usuario.login}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><c:out value="${usuario.cargo}" /></td>
                    <td><c:out value="${usuario.rg}" /></td>
                    <td><c:out value="${usuario.cpf}" /></td>
                    <td><c:out value="${usuario.endereco}" /></td>
                    <td><c:out value="${usuario.ativo}" /></td>
                    <td><c:out value="${usuario.perfil}" /></td>
                    <td><a href="UsuarioController?action=edit&userId=<c:out value="${usuario.id}"/>">Update</a></td>
                    <td><a href="delete?id=<c:out value='${usuario.id}'/>">Delete</a></td>

                </tr>
            </c:forEach>

        </table>
        <p><a href="cadastro_usuario.jsp">Add User</a></p>

    </body>
</html>
