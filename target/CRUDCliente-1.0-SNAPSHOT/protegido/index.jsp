<%-- 
    Document   : index
    Created on : 30 de nov. de 2021, 16:57:29
    Author     : Jamile
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <c:import url="../uteis/header.jsp"/>
        <div>Menu</div>
        <c:if test="${sessionScope.usuario.isGerente()}">
            <a href="${pageContext.request.contextPath}/protegido/cliente/cadastro.jsp">Cadastrar Cliente</a><br/>
            <a href="${pageContext.request.contextPath}/protegido/funcionario/cadastroFuncionario.jsp">Cadastrar Funcionario</a><br/>
            <a href="${pageContext.request.contextPath}/protegido/produto/cadastroProduto.jsp">Cadastrar Produto</a><br/>
            <a href="${pageContext.request.contxtPath}/protegido/relatorio/relaorio.jsp'"> Relatorio</a></br>
        </c:if>
        <a href="${pageContext.request.contextPath}/protegido/cliente/ListarClienteServlet">Listar Cliente</a><br/>
        <a href="${pageContext.request.contextPath}/protegido/cliente/busca.jsp">Buscar Cliente</a>
    </body>
</html>
