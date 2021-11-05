<%-- 
    Document   : cadastro
    Created on : 31/10/2021, 00:14:26
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

        <fieldset style="background-color: white; width: 90%; margin: auto; border: none; padding: 3%; border-radius: 20px; margin-top: 30px;">
            <h3 style="text-align: center; margin-bottom: 30px;"> CADASTRO FUNCIONARIO</h3>

            <form action="CadastroFuncionarioServlet" method="POST" class="card-title"> 

                <c:if test="${not empty funcionarioAtualizacao}">
                    <input type="hidden" name="ope" value="1"/>    
                </c:if>

                <label >Nome:</label>
                <input required type="text" name="nomeFuincionario" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${funcionarioAtualizacao.nome}"/>

                <label >CPF:</label>
                <input required type="text" name="cpfFuincionario" class="form-control" style="width: 35%" value="${funcionarioAtualizacao.cpf}" /><br/>

                <label>Email:</label>
                <input required type="text" name="emailFuincionario" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${funcionarioAtualizacao.email}"/>

                <label>Telefone:</label>
                <input type="text" name="telefoneFuincionario" class="form-control" style="width: 35%;float: left; margin-right: 2%;" value="${funcionarioAtualizacao.telefone}"/>
                <br/>
                <div style="margin-top: 40px;">
                    <label>Sexo:</label>
                    <strong>M:</strong>
                    <input type="radio" name="sexo" id="rboMaculino" checked="true" value="masculino">
                    <strong>F:</strong>
                    <input type="radio" name="sexo" id="rboFeminino" value="feminino"><br/>
                </div>      <br/>

                <label >Salario:</label>
                <input type="text" name="salarioFuincionario" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${funcionarioAtualizacao.salario}"/>

                <label >Cargo:</label> 
                <input type="text" name="cargoFuincionario" class="form-control" style="width: 30%"value="${funcionarioAtualizacao.cargo}" /><br/>
              
                <button type="submit" id="btnEnviar">Enviar</button>

            </form>
        </fieldset>
    </body>
</html>