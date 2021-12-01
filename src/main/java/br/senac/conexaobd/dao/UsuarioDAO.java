package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    public static Usuario getUsuario(String login, String senhaUsuario) {
        
        Usuario usuario = null;
        Connection con = Conexao.getConexao();
        String query = "select * from usuario where usuario=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senhaUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                String user = rs.getString("usuario");
                String senhaFechada = rs.getString("senha");            
                int fkcod = rs.getInt("fk_codfuncionario");             
                int acesso = rs.getInt("nivelacesso");
                usuario.setUsuario(user);
                usuario.setSenha(senhaFechada);
                usuario.setNivelAcesso(acesso);
                usuario.setFkCodFuncionario(fkcod);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
