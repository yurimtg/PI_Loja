<%-- 
    Document   : venda
    Created on : 19/10/2021, 19:06:33
    Author     : yurim
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../uteis/header.jsp"/>       

        <script type="text/javascript">

            $(document).ready(function () {

                $(':button').click(function () {

                    var row = $(this).closest("tr");
                    var codigo = row.find("td:eq(0)").text();
                    var modelo = row.find("td:eq(2)").text();
                    var valor = row.find("td:eq(3)").text();
                    var qtd = row.find("td:eq(6)").text();
                    var estoque = row.find("td:eq(4)");
                    estoque.html(estoque.text() - qtd);

                    var tr = '<tr><td>' + codigo + '</td><td>' + modelo + '</td><td>' + valor + '</td><td>' + qtd + '</td><td>' + qtd * valor + '</td></tr>';
                    $('#tblCarrinho tbody').append(tr);
                });

                $('.qtd').dblclick(function () {

                    var vInicial = $(this).text();
                    var input = $('<input/>', {type: 'text', value: vInicial, style: 'width: 30px'});
                    $(this).html(input.blur(function () {
                        var novoConteudo = $(this).val();
                        $(this).parent().html(novoConteudo);

                    }));

                });

            });

        </script>       

        <table id="tblVenda" name="venda" class="table table-striped" style="width: 90%; margin: auto">
            <thead>
            <td>Código</td><td>Marca</td><td>Modelo</td><td>Valor</td><td>Estoque</td><td>Tamanho</td><td style="width: 15%;">QTD</td><td></td>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${listaProduto}">
                <tr>
                    <td>${produto.codProduto}</td>
                    <td>${produto.marca}</td>
                    <td>${produto.modelo}</td>
                    <td>${produto.valor}</td>
                    <td>${produto.estoque}</td>
                    <td>${produto.tamanho}</td>
                    <td class="qtd">00</td>    
                    <td><button  class="btn-outline-dark">Adicionar</button></td> 
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2 style="margin-top: 20px; text-align: center">CARRINHO</h2>
    <table id="tblCarrinho" class="table table-striped" style="width: 90%; margin: auto;">
        <thead>
            <tr>
                <td style="width: 15%">ID</td>
                <td style="width: 40%">PRODUTO</td>
                <td style="width: 15%">VALOR</td>
                <td style="width: 15%">QTD</td>
                <td style="width: 15%">TOTAL</td>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</body>
</html>
