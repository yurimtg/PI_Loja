package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ItemVendaDAO {

    public static void inserirItemVenda(ItemVenda itemVenda) throws SQLException {

        String query = "insert into itemVenda(qtd,precoUnitario,subTotal,fk_codProduto,fk_codVenda) "
                + "values (?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setInt(1, itemVenda.getQtd());
        ps.setDouble(2, itemVenda.getPrecoUnitario());
        ps.setDouble(3, itemVenda.getSubTotal());
        ps.setInt(4, itemVenda.getFkCodProduto());
        ps.setInt(5, itemVenda.getFkCodVenda());
        ps.execute();

    }
    

}
