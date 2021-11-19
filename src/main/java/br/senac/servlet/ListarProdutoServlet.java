package br.senac.servlet;

import br.senac.conexaobd.dao.produtoDAO;
import br.senac.conexaobd.entidades.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/protegido/produto/listarProduto.jsp";
        List<Produto> produto = produtoDAO.getProduto();
        request.setAttribute("listaProduto", produto);

        String venda = request.getParameter("venda");
        if ("1".equals(venda)) {
            url = "/protegido/venda/venda.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
}
