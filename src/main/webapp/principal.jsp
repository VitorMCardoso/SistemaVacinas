<%-- 
    Document   : principal
    Created on : Mar 5, 2017, 7:18:22 PM
    Author     : vitor
--%>

<%@page import="model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

            if (usuario != null) {
        %>
        
        <title>Bem Vindo, <%= usuario.getNome()%> !</title>
    </head>
    <body>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function){
                $(".dropdown-button").dropdown();
            }
        </script>
        <!-- Dropdown Structure -->
        <ul id="dropdown1" class="dropdown-content">
            <li><a href="#!">one</a></li>
            <li><a href="#!">two</a></li>
            <li class="divider"></li>
            <li><a href="#!">three</a></li>
        </ul>
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo">Logo</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="sass.html">Sass</a></li>
                    <li><a href="badges.html">Components</a></li>
                    <!-- Dropdown Trigger -->
                    <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Dropdown</a></li>
                </ul>
            </div>
        </nav>

        <div align="center">
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

            <p><a href="data/showNewForm"><button>Cadastro de Data</button></a></p>
            <p><a href="data/listar"><button>Manter Data</button></a></p>
        </div>
    </body>
</html>
