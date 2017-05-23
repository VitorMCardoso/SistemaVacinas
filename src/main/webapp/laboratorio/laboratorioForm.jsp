<%-- 
    Document   : laboratorioForm
    Created on : Apr 23, 2017, 7:59:43 PM
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
        <h2>Gerenciamento de Laboratorio</h2>
    </center>
    <div align="center">
        <c:if test="${laboratorio != null}">
            <form action="updateLaboratorio" method="post">
            </c:if>
            <c:if test="${laboratorio == null}">
                <form action="insertLaboratorio" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>

                        <c:if test="${laboratorio != null}">
                            <h3>Editar Laboratorio</h3>
                        </c:if>
                        <c:if test="${laboratorio == null}">
                            <h3>Adicionar Novo Laboratorio</h3>
                        </c:if>

                    </caption>
                    <c:if test="${laboratorio != null}">
                        <tr>
                            <th>Id:</th>
                            <td>
                                <input type="text" name="id" value="<c:out value='${laboratorio.id}' />" />
                            </td>    
                        </tr>
                    </c:if>
                    <tr>
                        <th>Razao Social: </th>
                        <td>
                            <input type="text" name="razaoSocial" size="45"
                                   value="<c:out value='${laboratorio.razaoSocial}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>CNPJ: </th>
                        <td>
                            <input type="text" name="cnpj" size="45"
                                   value="<c:out value='${laboratorio.cnpj}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Registro Estadual </th>
                        <td>
                            <input type="text" name="registroEstadual" size="5"
                                   value="<c:out value='${laboratorio.registroEstadual}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Nome Fantasia </th>
                        <td>
                            <input type="text" name="nomeFantasia" size="45"
                                   value="<c:out value='${laboratorio.nomeFantasia}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Telefone </th>
                        <td>
                            <input type="text" name="telefone" size="45"
                                   value="<c:out value='${laboratorio.telefone}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Site </th>
                        <td>
                            <input type="text" name="site" size="9"
                                   value="<c:out value='${laboratorio.site}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>CEP </th>
                        <td>
                            <input type="text" name="cep" size="11"
                                   value="<c:out value='${laboratorio.cep}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Logradouro </th>
                        <td>
                            <input type="text" name="logradouro" size="45"
                                   value="<c:out value='${laboratorio.logradouro}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Numero </th>
                        <td>
                            <input type="text" name="numero" size="45"
                                   value="<c:out value='${laboratorio.numero}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Bairro </th>
                        <td>
                            <input type="text" name="bairro" size="45"
                                   value="<c:out value='${laboratorio.bairro}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Cidade </th>
                        <td>
                            <input type="text" name="cidade" size="45"
                                   value="<c:out value='${laboratorio.cidade}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Estado </th>
                        <td>
                            <select name="optEstado">
                                <option>AC</option>
                                <option>AL</option>
                                <option>AM</option>
                                <option>AP</option>
                                <option>BA</option>
                                <option>CE</option>
                                <option>DF</option>
                                <option>ES</option>
                                <option>GO</option>
                                <option>MA</option>
                                <option>MG</option>
                                <option>MS</option>
                                <option>MT</option>
                                <option>PA</option>
                                <option>PB</option>
                                <option>PE</option>
                                <option>PI</option>
                                <option>PR</option>
                                <option>RJ</option>
                                <option>RN</option>
                                <option>RO</option>
                                <option>RR</option>
                                <option>RS</option>
                                <option>SC</option>
                                <option>SE</option>
                                <option>SP</option>
                                <option>TO</option>
                                value="<c:out value='${usuario.estado}' />"
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
                    <a href="listLaboratorio">List All Laboratorio</a>
                </div>
            </form>
    </div>	
</body>
</html>
