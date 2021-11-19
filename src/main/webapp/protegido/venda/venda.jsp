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
//-------------------------------------------------------------------------------------------------------------------
                $('.btnADD').click(function () {

                    var row = $(this).closest("tr");
                    var qtd = row.find("td:eq(6)").text();
                    var estoque = row.find("td:eq(4)");
                    var estoqueAtual = estoque.text() - qtd;
                    if (qtd <= 0) {
                        alert("Informe a quantidade");
                        return;
                    }
                    if (estoqueAtual < 0) {
                        alert("Estoque insuficiente");
                        return;
                    }
                    var codigo = row.find("td:eq(0)").text();
                    var modelo = row.find("td:eq(2)").text();
                    var valor = row.find("td:eq(3)").text();
                    estoque.html(estoqueAtual);
                    var tr = '<tr><td class="td_codigo">' + codigo + '</td><td class="td_modelo">' + modelo + '</td><td class="td_valor">' + valor + '</td><td class="td_quantidade">' + qtd + '</td><td class="td_total">' + qtd * valor + '</td></tr>';
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
//-------------------------------------------------------------------------------------------------------------------
                $('#btnCompra').click(function () {

                    var codigo="";
                    var modelo="";
                    var valor="";
                    var qtd="";
                    var total="";

                    for (i = 0; i < $('.td_codigo').length; i++) {
                        codigo += $('.td_codigo')[i].firstChild.nodeValue + ",";
                        modelo += $('.td_modelo')[i].firstChild.nodeValue + ",";
                        valor += $('.td_valor')[i].firstChild.nodeValue + ",";
                        qtd += $('.td_quantidade')[i].firstChild.nodeValue + ",";
                        total += $('.td_total')[i].firstChild.nodeValue + ",";

                    }
                    
                    var url = "${pageContext.request.contextPath}/venda/VendaServlet?codigo=" + codigo + "&modelo=" + modelo + "&valor=" + valor + "&qtd=" + qtd + "&total=" + total;
                    $('#btnCompra').prop("href", url);

                    $.ajax(url).done(function () {
                        alert("Sucesso");
                        location.reload();
                    }).fail(function () {
                        alert("Falha");
                    });
                });
            });

        </script>       
        <h2 style="margin-top: 20px; text-align: center">ITENS VENDA</h2>

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
                    <td><button  class="btnADD">Adicionar</button></td> 
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2 style="margin-top: 100px; text-align: center">CARRINHO</h2>
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
    <div style="text-align: center; margin-top: 50px;" >
        <button id="btnCompra">COMPRAR</button> 
    </div>        
</body>
</html>