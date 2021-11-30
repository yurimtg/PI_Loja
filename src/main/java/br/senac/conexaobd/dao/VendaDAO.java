package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
        ps.setDouble(4,total);
        
        ps.execute();

    }
}
