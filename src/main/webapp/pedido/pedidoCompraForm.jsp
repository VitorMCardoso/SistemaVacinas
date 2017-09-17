<%-- 
    Document   : pedidoCompraForm
    Created on : Sep 17, 2017, 7:52:56 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h2>Gerenciamento de Pedido de COmpra</h2>
    </center>
    <div align="center">
        <c:if test="${pedido != null}">
            <form action="atualizar" method="post">
            </c:if>
            <c:if test="${pedido == null}">
                <form action="inserir" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${agendamento != null}">
                                Editar Pedido de Compra
                            </c:if>
                            <c:if test="${agendamento == null}">
                                Adicionar Novo Pedido de Compra
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${pedido != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${pedido.id}' />"/>
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Data </th>
                        <td>
                            <input type="text" name="data" size="45"
                                   value="<c:out value='${pedido.data}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Quantidade de Vacinas </th>
                        <td>
                            <input type="text" name="quantidadeVac" size="45"
                                   value="<c:out value='${pedido.quantidadeVac}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Laboratorio </th>
                        <td>
                            <input type="text" name="idLaboratorio" size="5"
                                   value="<c:out value='${pedido.idLaboratorio}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Vacinas </th>
                        <td>
                            <input type="text" name="idVacinas" size="45"
                                   value="<c:out value='${pedido.idVacinas}' />"
                                   />
                        </td>
                    </tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Salvar" />
                    </td>
                    </tr>
                </table><br>
                <div>
                    <a href="listar">List All Pedido</a>
                </div>
            </form>
    </div>	
</body>
</html>
