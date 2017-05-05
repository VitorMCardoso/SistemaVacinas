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
        <title>Cadastro de Pacientes</title>
    </head>
    <body>
        <center>
            <h2>Gerenciamento de Pacientes</h2><br>
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
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Estado</th>
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
                        <td><c:out value="${paciente.bairro}" /></td>
                        <td><c:out value="${paciente.cidade}" /></td>
                        <td><c:out value="${paciente.estado}" /></td>
                        <td><c:out value="${paciente.ativo}" /></td>
                        <td><a href="editPaciente?id=<c:out value="${paciente.id}"/>">Update</a></td>
                        <td><a href="deletePaciente?id=<c:out value='${paciente.id}'/>">Delete</a></td>

                    </tr>
                </c:forEach>

            </table><br>
            <div>
                <a href="newPaciente">Adicionar Novo Paciente</a>
                &nbsp; &nbsp;
                <a href="listPaciente">List All Paciente</a>
                &nbsp; &nbsp;
                <a href="principal">Home</a>
            </div>
        </center>
    </body>
</html>
