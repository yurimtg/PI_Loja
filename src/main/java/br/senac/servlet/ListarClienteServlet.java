package br.senac.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientes = ClienteDAO.getClientes();
        request.setAttribute("listaClientes", clientes);

        String url = "/protegido/cliente/listar.jsp";

        HttpSession sessao = request.getSession();
        sessao.setAttribute("clientes", clientes);

        String cpfCli = request.getParameter("cpfCliente");
        String vendaCli = request.getParameter("vendaCli");
        if ("1".equals(vendaCli)) {
            Cliente cliente = ClienteDAO.getClientePorCPF(cpfCli);
            sessao.setAttribute("cliente", cliente);
            url = "/protegido/venda/venda.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

}
