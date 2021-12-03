package br.senac.servlet;

import br.senac.conexaobd.dao.produtoDAO;
import br.senac.conexaobd.entidades.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/protegido/produto/listarProduto.jsp";
        List<Produto> produto = produtoDAO.getProduto();
        
            HttpSession sessao  = request.getSession();
            sessao.setAttribute("listaProduto", produto);

        String ope = request.getParameter("ope");
        if ("1".equals(ope)) {
            url =  "/protegido/venda/venda.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nomeProduto");
        nome += "%";
        List<Produto> produto = produtoDAO.getProdutoPorModelo(nome);
        request.setAttribute("listaProduto", produto);

        String url = "/protegido/venda/venda.jsp";

        HttpSession sessao = request.getSession();
        sessao.setAttribute("Produtos", produto);

        request.getRequestDispatcher(url).forward(request, response);
    }
}

