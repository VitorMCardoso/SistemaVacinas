<%-- 
    Document   : UsuarioForm
    Created on : Apr 21, 2017, 4:35:02 PM
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
        <h2>Gerenciamento de Usuarios</h2>
    </center>
    <div align="center">
        <c:if test="${usuario != null}">
            <form action="update" method="post">
            </c:if>
            <c:if test="${usuario == null}">
                <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${usuario != null}">
                                Editar Usuario
                            </c:if>
                            <c:if test="${usuario == null}">
                                Adicionar Novo Usario
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${usuario != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${usuario.id}' />"/>
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45"
                                   value="<c:out value='${usuario.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Sobrenome: </th>
                        <td>
                            <input type="text" name="sobrenome" size="45"
                                   value="<c:out value='${usuario.sobrenome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Login </th>
                        <td>
                            <input type="text" name="login" size="5"
                                   value="<c:out value='${usuario.login}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Email </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${usuario.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Senha </th>
                        <td>
                            <input type="password" name="senha" size="45"
                                   value="<c:out value='${usuario.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Cargo </th>
                        <td>
                            <select name="optCargo">
                                <option>GERENTE</option>
                                <option>SECRETARIA</option>
                                <option>ESTOQUISTA</option>
                                <br/>
                                value="<c:out value='${usuario.cargo}' />"
                                <select/>
                        </td>
                    </tr>
                    <tr>
                        <th>RG </th>
                        <td>
                            <input type="text" name="rg" size="9"
                                   value="<c:out value='${usuario.rg}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>CPF </th>
                        <td>
                            <input type="text" name="cpf" size="11"
                                   value="<c:out value='${usuario.cpf}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Endereco </th>
                        <td>
                            <input type="text" name="endereco" size="45"
                                   value="<c:out value='${usuario.endereco}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Perfil </th>
                        <td>
                            <select name="optPerfil">
                                <option>COMUM </option>
                                <option>ADMINISTRADOR</option>

                                value="<c:out value='${usuario.cargo}' />"
                                <select/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salvar" />
                        </td>
                    </tr>
                </table><br>
                <div>
                    <a href="list">List All Usuarios</a>
                </div>
            </form>
    </div>	
</body>
</html>
