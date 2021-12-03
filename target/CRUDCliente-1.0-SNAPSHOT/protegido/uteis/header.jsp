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

   <style>
        
        .barraMenu{
            background-color :#93e2d6
        }
        
    .container{
        background-image: url(../../img/tenis.jpeg);
               background-size: cover;
               background-repeat: no-repeat;
               background-size: cover;
               width: 100vw;
               height: 100vh;
               padding: 0;
               text-align: center;
             
       
            }
    </style>
    <body class="container">
       
        <div class="barraMenu">
            <div style=" width:20%;height: 50px; float: left;" id="divCadastro" >
                
                <h5 class="card-title"">CADASTRAR 
                    <img id="imgShow" src="${pageContext.request.contextPath}/img/add.png" style="visibility: visible">
                </h5>
                  
                <div  id="dropCadastro" style="display: none; text-align:center;  width: 13%; position: fixed;" >     
                    <c:if test="${sessionScope.funcionario.gerente }" >
                       
                    <a href="${pageContext.request.contextPath}/protegido/cliente/cadastro.jsp" class="btn btn-primary">Cliente</a><br/>
                    <a href="${pageContext.request.contextPath}/protegido/produto/cadastroProduto.jsp" class="btn btn-primary">Produto</a><br/> 
                    </c:if:>
                    <c:if test="${sessionScope.cargo.diretor}" >
                   <a href="${pageContext.request.contextPath}/protegido/funcionario/cadastroFuncionario.jsp" class="btn btn-primary">Funcionario</a>
                    </c:if>
                </div>
               
            </div>

            <div style="width:15%;height: 50px; float: left;" id="divLista" >
                <h5 class="card-title">LISTAR
                    <img id="imgShow1" src="${pageContext.request.contextPath}/img/add.png" style="visibility: visible">
               

                <div  id="dropLista" style="display: none; text-align:center; width: 10%; position: fixed">     
                    <a href="${pageContext.request.contextPath}/cliente/ListarClienteServlet" class="btn btn-primary">Cliente</a><br/>
                    <a href="${pageContext.request.contextPath}/produto/ListarProdutoServlet" class="btn btn-primary">Produto</a><br/>
                    <a href="${pageContext.request.contextPath}/funcionario/ListarFuncionarioServlet" class="btn btn-primary">Funcionario</a>
                </div>
            </div>

            <div style="width:15%;height: 50px; float: left;" >   
                <h5><a  href="${pageContext.request.contextPath}/produto/ListarProdutoServlet?ope=1" style="">VENDA</a></h5><br/>
            </div>

            
            <div style="width:25%;height: 50px; float: left;" >
                <c:if test="${sessionScope.funcionario.diretor}" >
                <h5> <a href="${pageContext.request.contextPath}/protegido/relatorio/relatorio.jsp">RELATÓRIO DE VENDA</a></h5><br/>
            </c:if>
            </div>
           
            </h5>
            <div style="width:25%;height: 50px; float: left;" >
                Bem Vindo, ${sessionScope.usuario.usuario}</br>
                <a href="${pageContext.request.contextPath}/LoginServlet"/>Sair</a>
        </div>

            </div>
    </body>
</html>