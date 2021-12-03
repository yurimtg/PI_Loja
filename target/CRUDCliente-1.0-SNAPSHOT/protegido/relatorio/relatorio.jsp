<%-- 
    Document   : relatoriojsp
    Created on : 22 de out. de 2021, 13:32:09
    Author     : Jamile
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
    </head>
   <body class="container">
             
        <c:import url="../uteis/header.jsp"/> 
       
        
        <div id="alerta" class="alert alert-success" role="alert" style="display:none">
          Busca feita com sucesso!
        </div>
        
        
        <form action="RelatorioServlet" method="POST" >
            <label id="dataini">Data Inicial:</label> <input name="dataIni" type="text">
            <label id="dataFin">Data Inicial:</label> <input name="dataFin" type="text">
            
            <button type="submit" class="btn btn-secondary">buscar</button>
        </form><br/>
        
        <h1>Relatório</h1>

        <table  class="table">
            <thead>
            <td>Nome</td><td>CPF</td><td>Data</td><td>Valor</td>
           
            
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${listaClientes}">
                <tr>
                    <div  class="form-group">
                    <label>Nome</label>
                    <input type="text" name="nomeCliente" value="${listaVendas}"
                       required class="form-control"/><br/> 
                    </div>
                    <div class="form-grup">
                    <label>Data</label>
                    <input type="text" name="dataCompra" value="${listaVendas}"
                       required class="form-control"/><br/> 
                   </div>
                    <div class="form-grup">
                   <label>CPF</label>
                    <input type="text" name="CpfCliente" value="${listaVendas}"
                       required class="form-control"/><br/> 
                    </div>
                    <div class="form-grup">
                   <label>Valor Total</label>
                    <input type="text" name="valorTotal" value="${listaVendas}"
                       required class="form-control"/><br/> 
                    </div>
                    <td><a href="BuscaClienteServlet?cpfUsuario=${cliente.cpf}&ope=1" >Buscar</a></td>
                    <td><button onclick="confirmarBusca('${cliente.nome}')" class="btn btn-link">Buscar</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    </body>
</html>
