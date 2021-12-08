<%-- 
    Document   : cadastro
    Created on : 17/09/2021, 21:00:14
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar de Clientes</title>
        <script type="text/javascript">

            var cpfRemocao;
            function confirmarRemocao(nome, cpf) {
                cpfRemocao = cpf;
                var confirmar = confirm("Deseja escluir o cliente: " + nome + " do CPF: " + cpf);
                if (confirmar) {
                    deletar();
                }
            }

            function deletar() {
                var url = "CadastroClienteServlet?cpfUsuario=" + cpfRemocao;
                $.ajax(url).done(function () {
                    alert("Sucesso");
                    location.reload();
                }).fail(function () {
                    alert("Falha");
                });
            }           
        </script>
    </head>
    <body class="container" style="background-image: url(../../img/tenis.jpeg); color: white">
        
      
        <c:import url="../uteis/header.jsp"/>

        <div style="width: 90%; margin: auto">
            <form form action="ListarClienteServlet" method="POST" style="margin: 2% 0 2% 0">
                <input type="text" name="nomeCli" style="width: 25%">
                <button type="submit" id="btnBuscar">Buscar</button>
            </form>

            <table  class="table table-striped">
                <thead>
                <td>CPF</td><td>Nome</td><td>Email</td><td>Telefone</td><td>Endereço</td><td>Nº</td><td>sexo</td>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${listaClientes}">
                        <tr>
                            <td>${cliente.cpf}</td>
                            <td>${cliente.nome}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.telefone }</td>
                            <td>${cliente.enderecoLogradouro}</td>
                            <td>${cliente.enderecoNumero}</td>
                            <td>${cliente.sexo }</td>
                            <td><a class="btn btn-link" href="CadastroClienteServlet?cpfUsuario=${cliente.cpf}&ope=1">Atualizar </a></td>
                            <td><button onclick="confirmarRemocao('${cliente.nome}', '${cliente.cpf}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
