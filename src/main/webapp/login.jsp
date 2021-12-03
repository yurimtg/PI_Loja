<%-- 
    Document   : index
    Created on : 18/10/2021, 09:55:25
    Author     : yurim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        .formLogin{
            margin-left: 37%;
            width: 25%;
            border: solid 2px;
            padding: 40px;
            margin-top: 100px;
            border-radius: 20px;
        }
        input{
            margin-bottom: 20px;
            height: 40px;
            width: 90%;
        }
        .btnLogar{
            width: 60%;
            background-color: black;
            color: white;
            height: 40px;
            margin-left: 20%;
        }
         .container{
            background-image: url(img/tenis.jpeg);
                 background-size: cover;
                background-repeat: no-repeat;
                background-size: cover;
                width: 100vw;
                height: 100vh;
                color:white;
             
             
                

    </style>
    <title>JSP Page</title>
</head>

<body class="container">


    <c:if test="${param.loginInvalido != null}">
        <div class="alert alert-danger" role="alert">
            Usuário/Senha inválidos
        </div>
    </c:if>
    <form method="post" action="LoginServlet" class="formLogin">
        <h2 style="color: red"><c:out value="${msgErro}"/></h2>

        <label>LOGIN:</label><br/>
        <input type="text" name="usuario" class="input-padrao"><br/>

        <label>SENHA:</label><br/>
        <input type="password" name="senha" class="input-padrao"><br/>

        <button type="submit"  class="btnLogar">LOGAR</button>

    </form>

</body>

