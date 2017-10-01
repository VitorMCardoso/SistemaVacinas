<%-- 
    Document   : principal
    Created on : Mar 5, 2017, 7:18:22 PM
    Author     : vitor
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

            if (usuario != null) {
        %>
        <title>Bem Vindo, <%= usuario.getNome()%> !</title>
    </head>
    <body>
        
        <div align="center">
        <h1>Menu de Opçoes</h1>
       
        <%}%>
        <p><a href="usuario/showNewForm"><button>Cadastro de Usuario</button></a></p>
        <p><a href="usuario/listar"><button>Manter Usuarios</button></a></p>
        
        <p><a href="pacientes/showNewForm"><button>Cadastro de Paciente</button></a></p>
        <p><a href="pacientes/listar" ><button>Manter Paciente</button></a></p>
        
        <p><a href="laboratorio/showNewForm"><button>Cadastro de Laboratorio</button></a></p>
        <p><a href="laboratorio/listar"><button>Manter Laboratorio</button></a></p>
        
        <p><a href="vacinas/showNewForm"><button>Cadastro de Vacinas</button></a></p>
        <p><a href="vacinas/listar"><button>Manter Vacina</button></a></p>
        
        <p><a href="agendamento/showNewForm"><button>Cadastro de Agendamento</button></a></p>
        <p><a href="agendamento/listar"><button>Manter Agendamento</button></a></p>
        
        <p><a href="pedido/showNewForm"><button>Cadastro de Pedido de Compra</button></a></p>
        <p><a href="pedido/listar"><button>Manter Pedido de Compra</button></a></p>
        
        <p><a href="lote/showNewForm"><button>Cadastro de Lote</button></a></p>
        <p><a href="lote/listar"><button>Manter Lote</button></a></p>
        </div>
    </body>
</html>
