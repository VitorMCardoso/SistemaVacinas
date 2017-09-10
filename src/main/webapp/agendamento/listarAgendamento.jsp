<%-- 
    Document   : listarAgendamento
    Created on : Apr 24, 2017, 10:03:25 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Show All Agendamento</title>
    </head>
    <body>
        <center>
            <h3>Gerenciamentos de Agendamento</h3>
            <table border=1>

                <tr>
                    <th>Id</th>
                    <th>Data da Dose</th>
                    <th>Quantidade</th>
                    <th>Id Paciente</th>
                    <th>Id Vacinas</th>
                    <th>Ativo</th>
                    <th colspan=2>Açao</th>
                </tr>


                <c:forEach var="agendamento" items="${listarAgendamentos}" >
                    <tr>

                        <td><c:out value="${agendamento.id}" /></td>
                        <td><c:out value="${agendamento.dataDose}" /></td>
                        <td><c:out value="${agendamento.quantidade}" /></td>
                        <td><c:out value="${agendamento.paciente}" /></td>
                        <td><c:out value="${agendamento.vacinas}" /></td>
                        <td><c:out value="${agendamento.ativo}" /></td>
                        
                        <td><a href="editAgendamentoForm?id=<c:out value="${agendamento.id}"/>">Update</a></td>
                        <td><a href="deleteAgendamento?id=<c:out value='${agendamento.id}'/>">Delete</a></td>

                    </tr>
                </c:forEach>

            </table><br>

                <a href="showNewForm">Adicionar Novo Agendamento</a>
            &nbsp; &nbsp;
                <a href="listarAgendamento">List All Agendamento</a>
            &nbsp; &nbsp;
                <a href="../principal.jsp">Home</a>
            </div>
        </center>
    </body>
</html>
