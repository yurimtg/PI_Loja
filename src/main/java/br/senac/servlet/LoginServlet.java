/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jamile
 */
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

    

