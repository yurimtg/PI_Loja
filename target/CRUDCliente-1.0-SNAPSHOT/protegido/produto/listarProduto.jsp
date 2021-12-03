<%-- 
    Document   : listarProduto
    Created on : 01/11/2021, 16:11:14
    Author     : yurim
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar de Produto</title>
        <script type="text/javascript">

            var codRemocao;
            function confirmarRemocao(modelo, cod) {
                codRemocao = cod;
                var confirmar = confirm("Deseja excluir o tenis " + modelo + " do codigo " + cod);
                if (confirmar) {
                    deletar();
                }
            }

            function deletar() {
                var url = "CadastroProdutoServlet?codigoProduto=" + codRemocao;
                $.ajax(url).done(function () {
                    alert("Sucesso");
                    location.reload();
                }).fail(function () {
                    alert("Falha");
                });
            }

        </script>
    </head>
    <body class="container">
        <c:import url="../uteis/header.jsp"/>

        <div style="width: 90%; margin: auto">   
            <form form action="ListarProdutoServlet" method="POST" style="margin: 2% 0 2% 0">
                <input type="text" name="nomeProduto" style="width: 25%">
                <button type="submit" id="btnBuscarProduto">Buscar</button>
            </form>

            <table  class="table table-striped">
                <thead>
                <td>Código</td><td>Marca</td><td>Modelo</td><td>Valor</td><td>Estoque</td><td>Tamanho</td><td>Filial</td>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${sessionScope.listaProduto}">
                        <tr>
                            <td>${produto.codProduto}</td>
                            <td>${produto.marca}</td>
                            <td>${produto.modelo}</td>
                            <td>${produto.valor }</td>
                            <td>${produto.estoque}</td>
                            <td>${produto.tamanho}</td>
                            <td>${produto.filial}</td>
                            <td><a class="btn btn-link" href="CadastroProdutoServlet?codigoProduto=${produto.codProduto}&ope=1">Atualizar </a></td>
                            <td><button onclick="confirmarRemocao('${produto.modelo}', '${produto.codProduto}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
