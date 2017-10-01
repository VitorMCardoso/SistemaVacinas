<%-- 
    Document   : listarLote
    Created on : Oct 1, 2017, 5:36:00 PM
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
            <h3>Gerenciamentos de Lotes</h3>
            <table border=1>

                <tr>
                    <th>Id</th>
                    <th>Quantidade</th>
                    <th>Id Laboratorio</th>
                    <th>Id Vacinas</th>
                    <th>Ativo</th>
                    <th colspan=2>Açao</th>
                </tr>

                <c:forEach var="lote" items="${listarLote}" >
                    <tr>

                        <td><c:out value="${lote.id}" /></td>
                        <td><c:out value="${lote.quantidadeVac}" /></td>
                        <td><c:out value="${lote.laboratorio.id}" /></td>
                        <td><c:out value="${lote.vacina.id}" /></td>
                        <td><c:out value="${lote.ativo}" /></td>

                        <td><a href="editForm?id=<c:out value='${lote.id}'/>">Atualizar</a></td>
                        <td><a href="deletar?id=<c:out value='${lote.id}'/>">Delete</a></td>
                    </tr>
                </c:forEach>

            </table><br>

            <a href="showNewForm">Adicionar Novo Lote</a>
            &nbsp; &nbsp;
            <a href="listar">List All Lote</a>
            &nbsp; &nbsp;
            <a href="../principal.jsp">Home</a>
        </div>
    </center>
</body>
</html>
