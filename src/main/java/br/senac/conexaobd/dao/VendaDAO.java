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

    public static void novaVenda(String data, int codCli, int codFuncionario, Double total) throws SQLException {

        String query = "insert into venda(data_venda,fk_codcli,fk_codfuncionario,valor_total) "
                + "values (?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);

        ps.setString(1, data);
        ps.setInt(2, codCli);
        ps.setInt(3, codFuncionario);
        ps.setDouble(4, total);

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
