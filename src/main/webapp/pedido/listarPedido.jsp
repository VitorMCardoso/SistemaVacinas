<%-- 
    Document   : listarPedido
    Created on : Sep 17, 2017, 7:52:19 PM
    Author     : vitor
--%>

<%@page import="java.util.Date"%>
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
                    <th>Data</th>
                    <th>Quantidade</th>
                    <th>Id Laboratorio</th>
                    <th>Id Vacinas</th>
                    <th>Ativo</th>
                    <th colspan=2>Açao</th>
                </tr>

                <c:forEach var="pedido" items="${listarPedido}" >
                    <tr>

                        <td><c:out value="${pedido.id}" /></td>
                        <td><c:out value="${pedido.data}" /></td>
                        <td><c:out value="${pedido.quantidadeVac}" /></td>
                        <td><c:out value="${pedido.idLaboratorio}" /></td>
                        <td><c:out value="${pedido.idVacinas}" /></td>
                        <td><c:out value="${pedido.ativo}" /></td>

                        <td><a href="confirmar?id=<c:out value='${pedido.id}'/>&quantidadeVac=<c:out value='${pedido.quantidadeVac}'/>">Confirmar</a></td>
                        <td><a href="deletar?id=<c:out value='${pedido.id}'/>">Delete</a></td>
                    </tr>
                </c:forEach>

            </table><br>

            <a href="showNewForm">Adicionar Novo Agendamento</a>
            &nbsp; &nbsp;
            <a href="listar">List All Agendamento</a>
            &nbsp; &nbsp;
            <a href="../principal.jsp">Home</a>
        </div>
    </center>
</body>
</html>

