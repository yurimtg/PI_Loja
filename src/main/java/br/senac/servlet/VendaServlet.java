package br.senac.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.dao.ItemVendaDAO;
import br.senac.conexaobd.dao.VendaDAO;
import br.senac.conexaobd.entidades.Cliente;
import br.senac.conexaobd.entidades.ItemVenda;
import br.senac.conexaobd.entidades.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vCod[] = req.getParameter("codigo").split(",");
        String vValor[] = req.getParameter("valor").split(",");
        String vQtd[] = req.getParameter("qtd").split(",");
        String vTotal[] = req.getParameter("total").split(",");
        String vModelo[] = req.getParameter("modelo").split(",");
        String cpfCli = req.getParameter("cpfCli");
        String pagamento = req.getParameter("formaPagamento");
        String user = req.getParameter("usuario");
        Double total = 0d;
        String filial = req.getParameter("filial");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String data = sdf.format(date);

        for (String valor : vTotal) {
            total += Double.parseDouble(valor);
        }

        try {
            Cliente cli = ClienteDAO.getClientePorCPF(cpfCli);
            String cliente = cli.getNome();

            VendaDAO.novaVenda(data, cliente, user, total, pagamento, filial);

            Venda venda = VendaDAO.getCodVenda();
            int codVenda = venda.getCodVenda();

            for (int i = 0; i < vCod.length; i++) {
                ItemVenda item = new ItemVenda();
                item.setProduto(vModelo[i]);
                item.setCodItemVenda(Integer.parseInt(vCod[i]));
                item.setFkCodVenda(codVenda);
                item.setPrecoUnitario(Double.parseDouble(vValor[i]));
                item.setQtd(Integer.parseInt(vQtd[i]));
                item.setSubTotal(Double.parseDouble(vValor[i]) * Integer.parseInt(vQtd[i]));
                ItemVendaDAO.inserirItemVenda(item);
            }

            resp.sendRedirect(req.getContextPath() + "/protegido/venda/venda.jsp");
        } catch (SQLException ex) {

        }

    }

}
