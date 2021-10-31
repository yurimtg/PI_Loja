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
            #btnEnviar{
                margin: 35px 36% 0px 36%;
                width: 25%; 
                background-color: #4d79ff; 
                color: white;
                border-radius: 10px;
                height: 35px;
                font-size: 20px;
            }
        </style>
    </head>
    <body class="container" style="background-color: #f2f2f2;">

        <c:import url="../uteis/header.jsp"/>


        <fieldset style="background-color: white; width: 90%; margin: auto; border: solid 1px; padding: 3%; border-radius: 50px; margin-top: 30px;">
            <h3 style="text-align: center; margin-bottom: 30px;"> CADASTRO CLIENTE</h3>

            <form action="CadastroClienteServlet" method="POST" class="card-title"> 

                <c:if test="${not empty clienteAtualizacao}">
                    <input type="hidden" name="ope" value="1"/>
                </c:if>

                <label >Nome:</label>
                <input required type="text" name="nomeCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${clienteAtualizacao.nome}"/>

                <label >CPF:</label>
                <input required type="text" name="cpfCliente" class="form-control" style="width: 35%" value="${clienteAtualizacao.cpf}" /><br/>

                <label>Email:</label>
                <input required type="text" name="emailCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${clienteAtualizacao.email}"/>

                <label>Telefone:</label>
                <input type="text" name="telefoneCliente" class="form-control" style="width: 35%;float: left; margin-right: 2%;" value="${clienteAtualizacao.telefone}"/>
                <br/>
                <div style="margin-top: 40px;">
                    <label>Sexo:</label>
                    <strong>M:</strong>
                    <input type="radio" name="sexo" id="rboMaculino" checked="true" value="masculino">
                    <strong>F:</strong>
                    <input type="radio" name="sexo" id="rboFeminino" value="feminino"><br/>
                </div>      <br/>

                <label >Endereço:</label>
                <input type="text" name="endCliente" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${clienteAtualizacao.enderecoLogradouro}"/>

                <label >Nº:</label> 
                <input type="text" name="nEndCliente" class="form-control" style="width: 10%"value="${clienteAtualizacao.enderecoNumero}" /><br/>

                <label style="width: 12%;">Complemento:</label>
                <input type="text" name="compCliente" class="form-control" style="width: 55%; float: left;" value="${clienteAtualizacao.enderecoComplemento}"/>


                <button type="submit" id="btnEnviar">Enviar</button>

            </form>
        </fieldset>
    </body>
</html>
