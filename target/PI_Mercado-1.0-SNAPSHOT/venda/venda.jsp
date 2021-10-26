<%-- 
    Document   : venda
    Created on : 19/10/2021, 19:06:33
    Author     : yurim
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                $("#txtBusca").attr("placeholder","Buscar Item" );    
            });
        </script>
        
        <fieldset style="width: 40%; float: left;">
            <legend style="text-align: center;">Lista de Produtos</legend>
            <table class="table">
                <thead>
                    <tr>
                        <td style="width: 20%">ID</td>
                        <td style="width: 40%">PRODUTO</td>
                        <td style="width: 20%">VALOR</td>
                        <td style="width: 20%">ESTOQUE</td>
                    </tr>
                </thead>
                <thead>

                </thead>
            </table>
        </fieldset>

        <fieldset style="width: 55%; margin-left: 45%;">
            <legend style="text-align: center; ">Carrinho</legend>
            <table class="table">
                <thead>
                    <tr>
                        <td style="width: 15%">ID</td>
                        <td style="width: 40%">PRODUTO</td>
                        <td style="width: 15%">VALOR</td>
                        <td style="width: 15%">QTD</td>
                        <td style="width: 15%">TOTAL</td>
                    </tr>
                </thead>
                <thead>

                </thead>
            </table>
        </fieldset>
    </body>
</html>
