<%-- 
    Document   : loteForm
    Created on : Oct 1, 2017, 5:35:46 PM
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
        <h2>Gerenciamento de Lote</h2>
    </center>
    <div align="center">
        <c:if test="${lote != null}">
            <form action="atualizar" method="post">
            </c:if>
            <c:if test="${lote== null}">
                <form action="inserir" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${lote != null}">
                                Editar Lote
                            </c:if>
                            <c:if test="${lote == null}">
                                Adicionar Lote
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${lote != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${lote.id}' />"/>
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Quantidade de Vacinas </th>
                        <td>
                                <input type="text" name="quantidadeVac" size="45"
                                   value="<c:out value='${lote.quantidadeVac}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Laboratorio </th>
                        <td>
                            <input type="text" name="idLaboratorio" size="5"
                                   value="<c:out value='${lote.laboratorio.id}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Vacinas </th>
                        <td>
                            <input type="text" name="idVacinas" size="45"
                                   value="<c:out value='${lote.vacina.id}' />"
                                   />
                        </td>
                    </tr>
                    
                    <td colspan="2" align="center">
                        <input type="submit" value="Salvar" />
                    </td>
                    </tr>
                </table><br>
                <div>
                    <a href="listar">List All Lote</a>
                </div>
            </form>
    </div>	
</body>
</html>

