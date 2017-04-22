<%-- 
    Document   : listarPaciente
    Created on : Apr 22, 2017, 4:59:49 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Show All Paciente</title>
    </head>
    <body>
        <center>
                    
                    <h3>
                            <a href="newPaciente">Adicionar Novo Paciente</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="listPaciente">List All Paciente</a>
                             
                        </h3>
                </center>
        <table border=1>

            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>Login</th>
                <th>Email</th>
                <th>RG</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>Ativo</th>
                <th colspan=2>Açao</th>
            </tr>


            <c:forEach var="paciente" items="${listarPaciente}" >
                <tr>

                    <td><c:out value="${paciente.id}" /></td>
                    <td><c:out value="${paciente.nome}" /></td>
                    <td><c:out value="${paciente.sobrenome}" /></td>
                    <td><c:out value="${paciente.login}" /></td>
                    <td><c:out value="${paciente.email}" /></td>
                    <td><c:out value="${paciente.rg}" /></td>
                    <td><c:out value="${paciente.cpf}" /></td>
                    <td><c:out value="${paciente.endereco}" /></td>
                    <td><c:out value="${paciente.ativo}" /></td>
                    <td><c:out value="${paciente.perfil}" /></td>
                    <td><a href="editPaciente?id=<c:out value="${paciente.id}"/>">Update</a></td>
                    <td><a href="deletePaciente?id=<c:out value='${paciente.id}'/>">Delete</a></td>

                </tr>
            </c:forEach>

        </table>
        <p><a href="new">Add Paciente</a></p>

    </body>
</html>
