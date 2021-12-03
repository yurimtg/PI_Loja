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
    <body class="container" style="background-color: #f2f2f2; color: white">

        <c:import url="../uteis/header.jsp"/>

        <fieldset style=" width: 90%; margin: auto; border: none; padding: 3%; border-radius: 20px; margin-top: 30px;">
            <h3 style="text-align: center; margin-bottom: 30px;"> CADASTRO FUNCIONARIO</h3>

            <form action="CadastroFuncionarioServlet" method="POST" class="card-title"> 

                <c:if test="${not empty funcionarioAtualizacao}">
                    <input type="hidden" name="ope" value="1"/>    
                </c:if>

                <label >Nome:</label>
                <input required type="text" name="nomeFuncionario" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${funcionarioAtualizacao.nome}"/>

                <label >CPF:</label>
                <input required type="text" name="cpfFuncionario" class="form-control" style="width: 35%" value="${funcionarioAtualizacao.cpf}" /><br/>

                <div class="input">
                    <label>Email:</label>
                    <input required type="text" name="emailFuncionario" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${funcionarioAtualizacao.email}"/>
                    <span class="error"></span>
                </div>
                <label>Telefone:</label>
                <input type="text" name="telefoneFuncionario" class="form-control" style="width: 35%;float: left; margin-right: 2%;" value="${funcionarioAtualizacao.telefone}"/>
                <br/>
                <div style="margin-top: 40px; width: 220px;">
                    <label>Sexo:</label>
                    <strong>M:</strong>
                    <input type="radio" name="sexo" id="rboMaculino" checked="true" value="masculino">
                    <strong>F:</strong>
                    <input type="radio" name="sexo" id="rboFeminino" value="feminino"><br/>
                </div>      <br/>
                 
               
                <label >Salario:</label>
                <input type="text" name="salarioFuncionário" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${funcionarioAtualizacao.salario}"/>

                 <label>Filial</label>
                  <select name="filial" id="filial" style="width: 30%; float: left; margin-right: 2%;">
                  <option value="SP"> SP</option>
                  <option value="RJ"> RJ</option>
                  <option value="RS"> RS</option>
                  </select>
                
                 </br>
                 </br>
                <label >Cargo:</label>  
                   <select name="cargoFuncionario" style="width: 30%">
                        <c:forEach var="cargo" items="${cargos}">
                        <option value="${cargo.cargo}">${cargo.cargo}</option>
                        </c:forEach>
                    </select>
                
                
                <button type="submit" id="btnEnviar">Enviar</button>
            </form>
        </fieldset>
    </body>
</html>