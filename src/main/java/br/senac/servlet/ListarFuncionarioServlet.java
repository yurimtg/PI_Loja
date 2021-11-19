
package br.senac.servlet;

import br.senac.conexaobd.dao.FuncionarioDAO;
import br.senac.conexaobd.entidades.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarFuncionarioServlet extends HttpServlet {
    
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         List<Funcionario> funcionario = FuncionarioDAO.getFuncionario();
        request.setAttribute("listaFuncionario", funcionario);

      
        String url = "/protegido/funcionario/listarFuncionario.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
