<%-- 
    Document   : agendamentoForm
    Created on : Apr 24, 2017, 10:03:13 PM
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
        <h2>Gerenciamento de Agendamento</h2>
    </center>
    <div align="center">
        <c:if test="${agendamento != null}">
            <form action="updateAgendamento" method="post">
            </c:if>
            <c:if test="${agendamento == null}">
                <form action="inserirAgendamento" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${agendamento != null}">
                                Editar Agendamento
                            </c:if>
                            <c:if test="${agendamento == null}">
                                Adicionar Novo Agendamento
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${agendamento != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${agendamento.id}' />"/>
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Data da Dose </th>
                        <td>
                            <input type="text" name="dataDose" size="45"
                                   value="<c:out value='${agendamento.dataDose}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Quantidade de Aplicaçoes </th>
                        <td>
                            <input type="text" name="quantidadeVac" size="45"
                                   value="<c:out value='${agendamento.quantidadeVac}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Paciente </th>
                        <td>
                            <input type="text" name="idPaciente" size="5"
                                   value="<c:out value='${agendamento.idPaciente}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Id Vacinas </th>
                        <td>
                            <input type="text" name="idVacinas" size="45"
                                   value="<c:out value='${agendamento.idVacinas}' />"
                                   />
                        </td>
                    </tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Salvar" />
                    </td>
                    </tr>
                </table><br>
                <div>
                    <a href="listarAgendamento">List All Agendamento</a>
                </div>
            </form>
    </div>	
</body>
</html>
