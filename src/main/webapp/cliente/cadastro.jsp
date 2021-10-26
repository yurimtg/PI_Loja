<%-- 
    Document   : cadastroCliente
    Created on : 18/10/2021, 09:57:44
    Author     : yurim
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
        <style>
            label{
                font-weight: bolder; float: left; margin-right: 10px; width: 7%;
            }
        </style>
    </head>
    <body class="container">

        <c:import url="../uteis/header.jsp"/>


        <fieldset style="width: 90%; margin: auto;">
            <legend style="text-align: center;">Formulário de Cadastro</legend>

            <form action="CadastroClienteServlet" method="POST">

                <label >Nome:</label>
                <input type="text" name="nomeCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;"/>

                <label >CPF:</label>
                <input type="text" name="cpfCliente" class="form-control" style="width: 35%" /><br/>

                <label>Telefone:</label>
                <input type="text" name="emailCliente" class="form-control" style="width: 35%;float: left; margin-right: 7%;"/>

                <label>Sexo:</label>
                <strong>M:<strong>
                <input type="radio" name="sexo" id="rboMaculino">
                
                <strong>F:<strong>
                <input type="radio" name="sexo" id="rboFeminino">
                <br/> 

                <br><button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </fieldset>
    </body>
</html>
