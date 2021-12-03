package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class produtoDAO {

    public static void inserirProduto(Produto produto) throws SQLException {
        boolean ok = true;
        String query = "insert into produto(marca,modelo,estoque,tamanho,valor,genero,filial)"
                + "values (?,?,?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        
        ps.setString(1, produto.getMarca());
        ps.setString(2, produto.getModelo());
        ps.setInt(3, produto.getEstoque());
        ps.setInt(4, produto.getTamanho());
        ps.setDouble(5, produto.getValor());
        ps.setString(6, produto.getGenero());
        ps.setString(7, produto.getFilial());
        
        ps.execute();
        
    }
    public static Produto getProdutoPorCod(int cod) {
        Produto produto = null;
        String query = "select * from produto where codProduto=?";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                produto = new Produto();

                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                Double valor = rs.getDouble("valor");
                int estoque = rs.getInt("estoque");
                int tamanho = rs.getInt("tamanho");
                String genero = rs.getString("genero");
                String filial = rs.getNString("filial");

                produto.setMarca(marca);
                produto.setModelo(modelo);
                produto.setValor(valor);
                produto.setEstoque(estoque);
                produto.setTamanho(tamanho);
                produto.setCodProduto(cod);
                produto.setGenero(genero);
                produto.setFilial(filial);

            }
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;

    }

    public static boolean deletarProduto(int cod) {
        boolean ok = true;
        String query = "delete from produto where codProduto=?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cod);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static boolean atualizarProduto(Produto produto) {
        boolean ok = true;
        String query = "update produto set marca=?,modelo=?,valor=?,estoque=?,tamanho=?,genero=?, filial=? where codProduto=?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setString(1, produto.getMarca());
            ps.setString(2, produto.getModelo());
            ps.setDouble(3, produto.getValor());
            ps.setInt(4, produto.getEstoque());
            ps.setDouble(5, produto.getTamanho());
            ps.setString(6, produto.getGenero());
            ps.setInt(7, produto.getCodProduto());
            ps.setString(8, produto.getFilial());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    } 
    
        public static List<Produto>getProduto(){
            List<Produto> produtos = new ArrayList();
            String query = "select * from produto";
            
            Connection con = Conexao.getConexao();
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    Double valor = rs.getDouble("valor");
                    int estoque = rs.getInt("estoque");
                    int tamanho = rs.getInt("tamanho");
                    int cod = rs.getInt("codProduto");
                    String genero = rs.getString("genero");
                    String filial = rs.getString("filial");
                    
                    produto.setMarca(marca);
                    produto.setModelo(modelo);
                    produto.setValor(valor);
                    produto.setEstoque(estoque);
                    produto.setTamanho(tamanho);
                    produto.setCodProduto(cod);
                    produto.setGenero(genero);
                    produto.setFilial(filial);
                    
                    produtos.add(produto);
                }
            } catch (SQLException ex) {
            }
            return produtos;
        }
}
