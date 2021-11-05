package br.senac.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String cpf = req.getParameter("codigo");
        String modelo = req.getParameter("modelo");
        String valor = req.getParameter("valor");
        String qtd = req.getParameter("qtd");
        String total = req.getParameter("total");
        
        
//            Cliente cliente = ClienteDAO.getClientePorCPF(cpf);
//            req.setAttribute("clienteAtualizacao", cliente);
//            req.getRequestDispatcher("/cliente/cadastro.jsp").forward(req, resp);

        }

    }

