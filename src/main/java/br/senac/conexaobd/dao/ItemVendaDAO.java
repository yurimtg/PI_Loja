package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.ItemVenda;
import br.senac.conexaobd.entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }
    
    public static List<ItemVenda> getItens(int codVenda) {
        List<ItemVenda> itens = new ArrayList<>();
        String query = "SELECT * FROM itemVenda WHERE FK_CODVENDA = ?";    
        Connection con = Conexao.getConexao();
        ItemVenda item;
        try {   
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, codVenda);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = new ItemVenda();
                
                int qtd = rs.getInt("qtd");
                Double precoUni = rs.getDouble("precoUnitario");
                Double subTotal = rs.getDouble("subTotal");
                String produto = rs.getString("produto");
                int codItem = rs.getInt("codItemVenda");

                item.setCodItemVenda(codVenda);
                item.setFkCodVenda(codItem);
                item.setPrecoUnitario(precoUni);
                item.setProduto(produto);
                item.setQtd(qtd);
                item.setSubTotal(subTotal);
                
                itens.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }
    

}
