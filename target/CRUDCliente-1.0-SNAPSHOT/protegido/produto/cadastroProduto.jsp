<%-- 
    Document   : cadastroProduto
    Created on : 01/11/2021, 16:10:54
    Author     : yurim
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
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
    <body class="container" style="background-color: #f2f2f2;color: white">
        
        <c:import url="../uteis/header.jsp"/>

        <fieldset style="width: 90%; margin: auto; border: none; padding: 3%; border-radius: 20px; margin-top: 30px;">
            <h3 style="text-align: center; margin-bottom: 30px;"> CADASTRO PRODUTO</h3>

            <form action="CadastroProdutoServlet" method="POST" class="card-title"> 
                
   
                <c:if test="${not empty produtoAtualizacao}">
                    <input type="hidden" name="ope" value="1"/>      
                    <input type="hidden" name="codProduto" value="${produtoAtualizacao.codProduto}"/>  
                </c:if>
                    
      
                <label >Marca:</label>
                <input required type="text" name="marcaProduto" class="form-control" style="width: 40%; float: left; margin-right: 2%;" value="${produtoAtualizacao.marca}"/>

                <label >Modelo:</label>
                <input required type="text" name="modeloProduto" class="form-control" style="width: 35%" value="${produtoAtualizacao.modelo}" /><br/>
               
                <div style="margin-top: 40px; width: 220px;">
                    <label>Genero:</label>
                    <strong>M:</strong>
                    <input type="radio" name="genero" id="rboMaculino" checked="true" value="masculino">
                    <strong>F:</strong>
                    <input type="radio" name="genero" id="rboFeminino" value="feminino"><br/>
                </div>      <br/>
                
                 <label>valor:</label>
                <input required type="text" name="valorProduto" class="form-control" style="width: 30%; float: left; margin-right: 2%;" value="${produtoAtualizacao.valor}"/>

                <label>Estoque:</label>
                <input required type="text" name="estoqueProduto" class="form-control" style="width: 15%;float: left; margin-right: 2%;" value="${produtoAtualizacao.estoque}"/>
                             
                <label >tamanho:</label>
                <input required type="text" name="tamanhoProduto" class="form-control" style="width: 15%; float: left; margin-right: 2%;" value="${produtoAtualizacao.tamanho}"/>
                
                </br>
                </br>
                <label>Filial</label>
                  <select name="filial" id="filial" style="width: 30%; float: left; margin-right: 2%;">
                  <option value="SP">SP</option>
                  <option value="RJ">RJ</option>
                  <option value="RS">RS</option>
                  </select>
                
                <button type="submit" id="btnEnviar">Enviar</button>

            </form>
        </fieldset>
    </body>
</html>
