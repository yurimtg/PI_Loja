package br.senac.servlet;

import br.senac.conexaobd.dao.FuncionarioDAO;
import br.senac.conexaobd.entidades.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
       
        
        Funcionario funcionario = null;
        try {
            funcionario = FuncionarioDAO.getUsuario(login);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("user", funcionario);
            response.sendRedirect(request.getContextPath());
            
    }
}

    

