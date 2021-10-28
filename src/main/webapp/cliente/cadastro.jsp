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


        <fieldset style="width: 90%; margin: auto; border: outset; padding: 5%;">
            <legend style="text-align: center;">Cadastro Cliente</legend>

            <form action="CadastroClienteServlet" method="POST">

                <label >Nome:</label>
                <input type="text" name="nomeCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;"/>

                <label >CPF:</label>
                <input type="text" name="cpfCliente" class="form-control" style="width: 35%" /><br/>

                <label>Email:</label>
                <input type="text" name="emailCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;"/>

                <label>Telefone:</label>
                <input type="text" name="telefoneCliente" class="form-control" style="width: 35%;float: left; margin-right: 2%;"/>
                <br/>
                <div style="margin-top: 40px;">
                    <label>Sexo:</label>
                    <strong>M:</strong>
                    <input type="radio" name="sexo" id="rboMaculino">
                    <strong>F:</strong>
                    <input type="radio" name="sexo" id="rboFeminino"><br/>
                </div>      <br/>

                <label >Endereço:</label>
                <input type="text" name="endCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;"/>

                <label >Nº:</label>
                <input type="text" name="nEndCliente" class="form-control" style="width: 10%" /><br/>
                
                <label style="width: 12%;">Complemento:</label>
                <input type="text" name="compCliente" class="form-control" style="width: 55%; float: left;"/>


                <button type="submit"  style="margin: 25px 36%; width: 25%;">Enviar</button>

            </form>
        </fieldset>
    </body>
</html>
