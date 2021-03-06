<%-- 
    Document   : listar
    Created on : 31/10/2021, 00:14:41
    Author     : yurim
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
                var url = "CadastroFuncionarioServlet?cpfUsuario=" + cpfRemocao;
                $.ajax(url).done(function () {
                    alert("Sucesso");
                    location.reload();
                }).fail(function () {
                    alert("Falha");
                });
            }

        </script>
    </head>
    <style>
        .container{
          
        }
    </style>
    <body class="container">
        <c:import url="../uteis/header.jsp"/>

        <div style="width: 90%; margin: auto">
            <form form action="ListarFuncionarioServlet" method="POST" style="margin: 2% 0 2% 0">
                <input type="text" name="nomeFuncionario" style="width: 25%">
                <button type="submit" id="btnBuscarFuncionario">Buscar</button>
            </form>

            <table  class="table table-striped">
                <thead>
                <td>CPF</td><td>Nome</td><td>Email</td><td>Telefone</td><td>Salario</td><td>Cargo</td><td>Filial</td>
                </thead>
                <tbody>
                    <c:forEach var="funcionario" items="${listaFuncionario}">
                        <tr>
                            <td>${funcionario.cpf}</td>
                            <td>${funcionario.nome}</td>
                            <td>${funcionario.email}</td>
                            <td>${funcionario.telefone }</td>
                            <td>${funcionario.salario}</td>
                            <td>${funcionario.cargo}</td>
                            <td>${funcionario.filial }</td>
                            <td><a class="btn btn-link" href="CargoServlet?cpfUsuario=${funcionario.cpf}&ope=1">Atualizar </a></td>
                            <td><button onclick="confirmarRemocao('${funcionario.nome}', '${funcionario.cpf}')" class="btn btn-link">Deletar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>