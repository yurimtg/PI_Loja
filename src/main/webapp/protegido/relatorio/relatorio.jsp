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
        <title>Relatório Sintetico</title>
    </head>
    <style>
        .container{
        
        background-image: url(../../img/tenis.jpeg);
               background-size: cover;
               background-repeat: no-repeat;
               background-size: cover;
               width: 100vw;
               height: 100vh;
               padding: 0;
               text-align: center;
               color: white
        }
    </style>
    
    <body class="container">

        <c:import url="../uteis/header.jsp"/> 

        <div style="width: 90%; margin: auto;">
            <form action="RelatorioServlet" method="POST" >
                <label id="dataini">Data Inicial:</label> <input name="dataIni" type="text">
                <label id="dataFin">Data Inicial:</label> <input name="dataFin" type="text">

                <button type="submit" class="btn btn-secondary">buscar</button>
            </form><br/>

            <h1>Relatório Sintetico</h1>

            <table  class="table">
                <thead>
                <td>Cod</td><td>Cliente</td><td>Vendedor</td><td>Total</td><td>Data Venda</td><td>Pagamento</td>


                </thead>
                <tbody>
                    <c:forEach var="venda" items="${ListaVenda}">
                        <tr>
                            <td>${venda.codVenda}</td>
                            <td>${venda.nomeCli}</td>
                            <td>${venda.nomeFuncionario}</td>
                            <td>${venda.totalVenda}</td>
                            <td>${venda.dataVenda}</td>
                            <td>${venda.pagamento}</td>
                            <td><a class="btn btn-link" href="RelatorioServlet?codVenda=${venda.codVenda}">Analitico </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h1>Relatório Analitico</h1>
            <table  class="table">
                <thead>
                <td>Cod</td><td>Produto</td><td>QTD</td><td>Preço un</td><td>Subtotal</td>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${listaItens}">
                        <tr>
                            <td>${item.codItemVenda}</td>
                            <td>${item.produto}</td>
                            <td>${item.qtd}</td>
                            <td>${item.precoUnitario}</td>
                            <td>${item.subTotal}</td>      
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
