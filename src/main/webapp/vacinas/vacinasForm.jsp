<%-- 
    Document   : vacinasForm
    Created on : Apr 24, 2017, 1:51:54 PM
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
        <h2>Gerenciamento de Vacinas</h2>
    </center>
    <div align="center">
        <c:if test="${vacina != null}">
            <form action="atualizar" method="post">
            </c:if>
            <c:if test="${vacina == null}">
                <form action="inserir" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${vacina != null}">
                                Editar Vacinas
                            </c:if>
                            <c:if test="${vacina == null}">
                                Adicionar Nova Vacina
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${vacina != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${vacina.id}' />"/>
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Nome </th>
                        <td>
                            <input type="text" name="nome" size="5"
                                   value="<c:out value='${vacina.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Tipo </th>
                        <td>
                            <input type="text" name="tipo" size="45"
                                   value="<c:out value='${vacina.tipo}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salvar" />
                        </td>
                    </tr>
                </table><br>
                <div>
                    <a href="listar">List All Vacinas</a>
                </div>
            </form>
    </div>	
</body>
</html>

