<%-- 
    Document   : pacienteForm
    Created on : Apr 22, 2017, 4:56:42 PM
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
        <h2>Gerenciamento de Paciente</h2>
    </center>
    <div align="center">
        <c:if test="${paciente != null}">
            <form action="updatePaciente" method="post">
            </c:if>
            <c:if test="${paciente == null}">
                <form action="insertPaciente" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        
                            <c:if test="${paciente != null}">
                                <h3>Editar Paciente</h3>
                            </c:if>
                            <c:if test="${paciente == null}">
                                <h3>Adicionar Novo Paciente</h3>
                            </c:if>
                       
                    </caption>
                    <c:if test="${paciente != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${paciente.id}' />" />
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45"
                                   value="<c:out value='${paciente.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Sobrenome: </th>
                        <td>
                            <input type="text" name="sobrenome" size="45"
                                   value="<c:out value='${paciente.sobrenome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Login </th>
                        <td>
                            <input type="text" name="login" size="5"
                                   value="<c:out value='${paciente.login}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Email </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${paciente.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Senha </th>
                        <td>
                            <input type="password" name="senha" size="45"
                                   value="<c:out value='${paciente.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>RG </th>
                        <td>
                            <input type="text" name="rg" size="9"
                                   value="<c:out value='${paciente.rg}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>CPF </th>
                        <td>
                            <input type="text" name="cpf" size="11"
                                   value="<c:out value='${paciente.cpf}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Endereco </th>
                        <td>
                            <input type="text" name="endereco" size="45"
                                   value="<c:out value='${paciente.endereco}' />"
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
                <a href="listPaciente">List All Paciente</a>
                </div>
            </form>
    </div>	
</body>
</html>
