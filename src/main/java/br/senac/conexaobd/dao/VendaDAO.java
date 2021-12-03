package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    public static void novaVenda(String data, String cliente, String funcionario, Double total, String pagamento, String filial)
            throws SQLException {

        String query = "insert into venda(data_venda,nomeCli,nomeFuncionario,valor_total,pagamento, filial) "
                + "values (?,?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);

        ps.setString(1, data);
        ps.setString(2, cliente);
        ps.setString(3, funcionario);
        ps.setDouble(4, total);
        ps.setString(5, pagamento);
        ps.setString(6, filial);
        ps.execute();

    }

    public static Venda getCodVenda() {
        Venda venda = null;
        String query = "SELECT * FROM SENAC.VENDA ORDER BY CODVENDA DESC FETCH FIRST 1 ROWS ONLY";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venda = new Venda();
                int cod = rs.getInt("codVenda");

                venda.setCodVenda(cod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }
    
    public static List<Venda> getVendas(String dataIni, String dataFin) {
        List<Venda> vendas = new ArrayList<>();
        String query = "SELECT * FROM VENDA WHERE DATA_VENDA > ? AND DATA_VENDA < ?";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, dataIni);
             ps.setString(2, dataFin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                int codVenda = rs.getInt("codVenda");
                String data = rs.getString("data_venda");
                String nomeCli = rs.getString("nomeCli");
                String nomeFuncionario = rs.getString("nomeFuncionario");
                Double total = rs.getDouble("valor_total");
                String pagamento = rs.getString("pagamento");
                String filial = rs.getNString("filial");

                venda.setCodVenda(codVenda);
                venda.setDataVenda(data);
                venda.setNomeCli(nomeCli);
                venda.setNomeFuncionario(nomeFuncionario);
                venda.setTotalVenda(total);
                venda.setPagamento(pagamento);
                venda.setFilial(filial);
           
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
}
