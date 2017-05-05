<%-- 
    Document   : listarLaboratorio
    Created on : Apr 23, 2017, 7:59:54 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Cadastro de Laboratorios</title>
    </head>
    <body>
        <center>
            <h2>Gerenciamento de Laboratorios</h2><br>
                <table border=1>

                <tr>
                    <th>Id</th>
                    <th>Razao Social</th>
                    <th>CNPJ</th>
                    <th>Registro Estadual</th>
                    <th>Nome Fantasia</th>
                    <th>Telefone</th>
                    <th>Site</th>
                    <th>CEP</th>
                    <th>Logradouro</th>
                    <th>Numero</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>Ativo</th>
                    <th colspan=2>Açao</th>
                </tr>


                <c:forEach var="laboratorio" items="${listarLaboratorio}" >
                    <tr>

                        <td><c:out value="${laboratorio.id}" /></td>
                        <td><c:out value="${laboratorio.razaoSocial}" /></td>
                        <td><c:out value="${laboratorio.cnpj}" /></td>
                        <td><c:out value="${laboratorio.registroEstadual}" /></td>
                        <td><c:out value="${laboratorio.nomeFantasia}" /></td>
                        <td><c:out value="${laboratorio.telefone}" /></td>
                        <td><c:out value="${laboratorio.site}" /></td>
                        <td><c:out value="${laboratorio.cep}" /></td>
                        <td><c:out value="${laboratorio.logradouro}" /></td>
                        <td><c:out value="${laboratorio.numero}" /></td>
                        <td><c:out value="${laboratorio.bairro}" /></td>
                        <td><c:out value="${laboratorio.cidade}" /></td>
                        <td><c:out value="${laboratorio.estado}" /></td>
                        <td><c:out value="${laboratorio.ativo}" /></td>
                        <td><a href="editLaboratorio?id=<c:out value="${laboratorio.id}"/>">Update</a></td>
                        <td><a href="deleteLaboratorio?id=<c:out value='${laboratorio.id}'/>">Delete</a></td>

                    </tr>
                </c:forEach>

            </table><br>
            <div>
                <a href="newLaboratorio">Adicionar Novo Laboratorio</a>
                &nbsp; &nbsp;
                <a href="listLaboratorio">List All Laboratorio</a>
                &nbsp; &nbsp;
                <a href="principal">Home</a>
            </div>
        </center>
    </body>
</html>
