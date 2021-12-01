package br.senac.servlet;

import br.senac.conexaobd.dao.UsuarioDAO;
import br.senac.conexaobd.entidades.Usuario;
import br.senac.uteis.CryptoUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");
       
        Usuario usuario = UsuarioDAO.getUsuario(login);
           
        if(login == null){
            HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath()+"/protegido/header.jsp");
          
            
         
        }else{
   
               response.sendRedirect(request.getContextPath()+"/login.jsp?loginInvalido=true");
        
            
    }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao  = request.getSession();
        sessao.invalidate();
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        
    }
}

    

