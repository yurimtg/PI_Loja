<%-- 
    Document   : header
    Created on : 01/10/2021, 19:35:46
    Author     : tiago.bscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/lib/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/lib/script.js" type="text/javascript"></script>

        <link href="${pageContext.request.contextPath}/lib/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/lib/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="container">

        <div class="barraMenu">
            <div style="width:20%;height: 50px; float: left;" id="divCadastro" >
                <h5 class="card-title"">CADASTRAR 
                    <img id="imgShow" src="../img/add.png" style="visibility: visible">
                </h5>

                <div  id="dropCadastro" style="display: none; text-align:center;  width: 13%; position: fixed;" >     
                    <a href="${pageContext.request.contextPath}/cliente/cadastro.jsp" class="btn btn-primary">Cliente</a><br/>
                    <a href="${pageContext.request.contextPath}/produto/cadastroProduto.jsp" class="btn btn-primary">Produto</a><br/>
                    <a href="${pageContext.request.contextPath}/funcionario/cadastroFuncionario.jsp" class="btn btn-primary">Funcionario</a>
                </div>
            </div>

            <div style="width:15%;height: 50px; float: left;" id="divLista" >
                <h5 class="card-title">LISTAR
                    <img id="imgShow1" src="../img/add.png" style="visibility: visible">
                </h5>

                <div  id="dropLista" style="display: none; text-align:center; width: 10%; position: fixed">     
                    <a href="${pageContext.request.contextPath}/cliente/ListarClienteServlet" class="btn btn-primary">Cliente</a><br/>
                    <a href="${pageContext.request.contextPath}/produto/ListarProdutoServlet" class="btn btn-primary">Produto</a><br/>
                    <a href="${pageContext.request.contextPath}/funcionario/ListarFuncionarioServlet" class="btn btn-primary">Funcionario</a>
                </div>
            </div>

            <div style="width:15%;height: 50px; float: left;" >   
                <h5><a  href="${pageContext.request.contextPath}/produto/ListarProdutoServlet?venda=1" style="">VENDA</a></h5><br/>
            </div>

            <div style="width:25%;height: 50px; float: left;" >
                <h5> <a href="${pageContext.request.contextPath}/relatorio/relatorio.jsp">RELATÓRIO DE VENDA</a></h5><br/>
            </div>
        </div>


    </body>
</html> 
