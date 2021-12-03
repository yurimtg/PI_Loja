package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    public static void novaVenda(String data, String cliente, String funcionario, Double total, String pagamento)
            throws SQLException {

        String query = "insert into venda(data_venda,nomeCli,nomeFuncionario,valor_total,pagamento) "
                + "values (?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);

        ps.setString(1, data);
        ps.setString(2, cliente);
        ps.setString(3, funcionario);
        ps.setDouble(4, total);
        ps.setString(5, pagamento);
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }
}
