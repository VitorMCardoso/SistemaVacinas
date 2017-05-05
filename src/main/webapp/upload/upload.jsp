<%-- 
    Document   : upload
    Created on : May 3, 2017, 9:08:32 PM
    Author     : vitor
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Imagens com servlet</title>
    </head>
    <body>
        <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file" id="file"/> 
            <input type="submit" value="Enviar" />
        </form>
        <label>${message}</label>
        <br/>
        <br/>
        <br/>
        <br/>
        <form action="upload" method="get" >
            <input type="submit" value="Visalizar imagem" />
        </form>
    </body>
</html>
