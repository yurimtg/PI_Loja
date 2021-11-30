package br.senac.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.dao.VendaDAO;
import br.senac.conexaobd.entidades.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String cpfCli = req.getParameter("cpfCli");
        String pagamento = req.getParameter("formaPagamento");
        int user = Integer.parseInt(req.getParameter("usuario"));
        Double total = 0d;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String data = sdf.format(date);

        for (String valor : vTotal) {
            total += Double.parseDouble(valor);
        }
        Cliente cli = ClienteDAO.getClientePorCPF(cpfCli);
        int codCli = cli.getCodigo();

        try {
            VendaDAO.novaVenda(data, codCli, user, total);
            resp.sendRedirect("/protegido/venda/venda.jsp");
        } catch (SQLException ex) {
            
        }
        
        resp.sendRedirect(req.getContextPath()+"/protegido/venda/venda.jsp");
    }

}
