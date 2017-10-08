<%-- 
    Document   : dataForm
    Created on : Oct 7, 2017, 9:00:33 AM
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
        <h2>Gerenciamento de Data</h2>
    </center>
    <div align="center">
        <c:if test="${data != null}">
            <form action="atualizar" method="post">
            </c:if>
            <c:if test="${data == null}">
                <form action="inserir" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${data != null}">
                                Editar Data
                            </c:if>
                            <c:if test="${data == null}">
                                Adicionar Data
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${data != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${data.id}' />"/>
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Data de Fabricaçao </th>
                        <td>
                                <input type="text" name="dataFabricacao" size="45"
                                   value="<c:out value='${data.dataFabricacao}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Data de Validade </th>
                        <td>
                            <input type="text" name="dataValidade" size="45"
                                   value="<c:out value='${data.dataValidade}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Lote </th>
                        <td>
                            <input type="text" name="idLote" size="45"
                                   value="<c:out value='${data.lote.id}' />"
                                   />
                        </td>
                    </tr>
                    
                    <td colspan="2" align="center">
                        <input type="submit" value="Salvar" />
                    </td>
                    </tr>
                </table><br>
                <div>
                    <a href="listar">List All Data</a>
                </div>
            </form>
    </div>	
</body>
</html>
