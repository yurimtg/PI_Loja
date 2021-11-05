<%-- 
    Document   : login
    Created on : 4 de nov. de 2021, 18:10:33
    Author     : Jamile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <header>

        </header>
        <main>
        
            <form method="post" action="LoginServlet">
            <h2 style="color: red"><c:out value="${msgErro}"/></h2>

            <label>Login</label>
            <input type="text" name="usuario" class="input-padrao">
            
            <label>Senha</label>
            <input type="password" name="senha" class="input-padrao">
            <br> <br>
            <input type="submit" name="btnLogin" value="Entrar" class="enviar" >

            </form>
        </main>
       
    </body>
</html>
