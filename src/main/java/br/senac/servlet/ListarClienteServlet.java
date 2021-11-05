
package br.senac.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListarClienteServlet extends HttpServlet {    

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> clientes = ClienteDAO.getClientes();
        request.setAttribute("listaClientes", clientes);

        String url = "/cliente/listar.jsp";
        request.getRequestDispatcher(url).forward(request, response);       
    }
  
}
