package br.senac.servlet;

import br.senac.conexaobd.dao.produtoDAO;
import br.senac.conexaobd.entidades.Produto;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yurim
 */
public class CadastroProdutoServlet extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      String ope = request.getParameter("ope");
        
        // Passo 1 - Recuperar os parametros
        String marca = request.getParameter("marcaProduto");
        String modelo = request.getParameter("modeloProduto");
        Double valor = Double.parseDouble(request.getParameter("valorProduto"));
        int estoque = Integer.parseInt(request.getParameter("estoqueProduto"));
        int tamanho = Integer.parseInt(request.getParameter("tamanhoProduto"));
        int cod = 0;
        if(request.getParameter("codProduto") != null){cod = Integer.parseInt(request.getParameter("codProduto"));}
       
        String genero;

        if (request.getParameter("genero").equals("masculino")) {
            genero = "M";
        }else{
            genero = "F";
        }

        // Passo 2 - Inserir no BD
       Produto produto = new Produto();
        
        produto.setModelo(modelo);
        produto.setMarca(marca);
        produto.setValor(valor);
        produto.setGenero(genero);
        produto.setEstoque(estoque);
        produto.setTamanho(tamanho);
        produto.setCodProduto(cod);

        try {
            // ope = 1 => Update
            if ("1".equals(ope)) {
                produtoDAO.atualizarProduto(produto);
            } else {
                
                produtoDAO.inserirProduto(produto);
            }
            response.sendRedirect(request.getContextPath() + "/uteis/sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect(request.getContextPath() + "/uteis/erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cod = Integer.parseInt(req.getParameter("codigoProduto"));
        String ope = req.getParameter("ope");
        //OPE = 1 => Atualização
        if ("1".equals(ope)) {
            Produto produto = produtoDAO.getProdutoPorCod(cod);
            req.setAttribute("produtoAtualizacao", produto);
            req.getRequestDispatcher("/produto/cadastroProduto.jsp").forward(req, resp);
        } else {
            produtoDAO.deletarProduto(cod);
            resp.sendRedirect(req.getContextPath() + "/produto/ListarProdutoServlet");
        }

    }

}
