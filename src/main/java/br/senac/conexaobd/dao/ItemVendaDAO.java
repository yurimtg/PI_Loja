package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ItemVendaDAO {

    public static void inserirItemVenda(ItemVenda itemVenda) throws SQLException {

        String query = "insert into itemVenda(qtd,precoUnitario,subTotal,Produto,fk_codVenda) "
                + "values (?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setInt(1, itemVenda.getQtd());
        ps.setDouble(2, itemVenda.getPrecoUnitario());
        ps.setDouble(3, itemVenda.getSubTotal());
        ps.setString(4, itemVenda.getProduto());
        ps.setInt(5, itemVenda.getFkCodVenda());
        ps.execute();

    }
    

}
