package br.senac.servlet;

import br.senac.conexaobd.dao.ItemVendaDAO;
import br.senac.conexaobd.dao.VendaDAO;
import br.senac.conexaobd.entidades.ItemVenda;
import br.senac.conexaobd.entidades.Venda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RelatorioServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String dataIni = request.getParameter("dataIni");
            String dataFin = request.getParameter("dataFin");
            
        String d = dataIni.substring(0, 2);
        String m = dataIni.substring(3, 5);
        String a = dataIni.substring(6, 10);
        String dataIniForm = a+"-"+m+"-"+d;
        String df = dataFin.substring(0, 2);
        String mf = dataFin.substring(3, 5);
        String af = dataFin.substring(6, 10);
        String dataFinForm = af+"-"+mf+"-"+df;
        
        List <Venda> vendas = VendaDAO.getVendas(dataIniForm, dataFinForm);
         for (Venda venda : vendas) {
          a = venda.getDataVenda().substring(0, 4);
          m = venda.getDataVenda().substring(5, 7);
          d = venda.getDataVenda().substring(8, 10);
          
          dataFinForm = d+"-"+m+"-"+a;
          
          venda.setDataVenda(dataFinForm);
         }
        String url = "/protegido/relatorio/relatorio.jsp";
        
            HttpSession sessao  = request.getSession();
            sessao.setAttribute("ListaVenda", vendas);


        request.getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cod = Integer.parseInt(req.getParameter("codVenda"));

            List <ItemVenda> itemVenda = ItemVendaDAO.getItens(cod);
            req.setAttribute("listaItens", itemVenda);
            req.getRequestDispatcher("/protegido/relatorio/relatorio.jsp").forward(req, resp);
        

    }
}
