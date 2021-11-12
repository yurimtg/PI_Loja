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

        String vCod[] = req.getParameter("codigo").split(",");
        String vModelo[] = req.getParameter("modelo").split(",");
        String vValor[] = req.getParameter("valor").split(",");
        String vQtd[] = req.getParameter("qtd").split(",");
        String vTotal[] = req.getParameter("total").split(",");

//            Cliente cliente = ClienteDAO.getClientePorCPF(cpf);
//            req.setAttribute("clienteAtualizacao", cliente);
//            req.getRequestDispatcher("/cliente/cadastro.jsp").forward(req, resp);
    }

}
