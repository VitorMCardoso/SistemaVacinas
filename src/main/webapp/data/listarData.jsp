<%-- 
    Document   : listarData
    Created on : Oct 7, 2017, 9:00:44 AM
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
        <title>Show All Datas</title>
    </head>
    <body>
        <center>
            <h3>Gerenciamentos de Datas</h3>
            <table border=1>

                <tr>
                    <th>Id</th>
                    <th>Data Validade</th>
                    <th>Data Fabricaçao</th>
                    <th>Id Lote</th>
                    <th colspan=2>Açao</th>
                </tr>
//
                <c:forEach var="data" items="${listarDatas}" >
                    <tr>

                        <td><c:out value="${data.id}" /></td>
                        <td><c:out value="${data.dataValidade}" /></td>
                        <td><c:out value="${data.dataFabricacao}" /></td>
                        <td><c:out value="${data.lote.id}" /></td>

                        <td><a href="editForm?id=<c:out value='${data.id}'/>">Atualizar</a></td>
                        <td><a href="deletar?id=<c:out value='${data.id}'/>">Delete</a></td>
                    </tr>
                </c:forEach>

            </table><br>

            <a href="showNewForm">Configurar Nova Data</a>
            &nbsp; &nbsp;
            <a href="listar">List All Data</a>
            &nbsp; &nbsp;
            <a href="../principal.jsp">Home</a>
        </div>
    </center>
</body>
</html>
