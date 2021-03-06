package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public static void inserirCliente(Cliente cliente) throws SQLException {
        boolean ok = true;
        String query = "insert into cliente(nome,cpf,email,sexo,telefone,enderecoLogradouro,enderecoNumero,enderecoComplemento) "
                + "values (?,?,?,?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getSexo());
        ps.setString(5, cliente.getTelefone());
        ps.setString(6, cliente.getEnderecoLogradouro());
        ps.setInt(7, cliente.getEnderecoNumero());
        ps.setString(8, cliente.getEnderecoComplemento());
        ps.execute();

    }

    public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("enderecoLogradouro");
                int endNumero = rs.getInt("enderecoNumero");
                String complemento = rs.getString("enderecoComplemento");
                String sexo = rs.getString("sexo");
                int cod = rs.getInt("codigo");

                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setTelefone(telefone);
                cliente.setEnderecoLogradouro(endereco);
                cliente.setEnderecoNumero(endNumero);
                cliente.setEnderecoComplemento(complemento);
                cliente.setSexo(sexo);
                cliente.setCodigo(cod);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public static Cliente getClientePorCPF(String cpf) {
        Cliente cliente = null;
        String query = "select * from cliente where cpf=?";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("enderecoLogradouro");
                int endNumero = rs.getInt("enderecoNumero");
                String complemento = rs.getString("enderecoComplemento");
                String sexo = rs.getString("sexo");
                int cod = rs.getInt("codigo");
                
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setTelefone(telefone);
                cliente.setEnderecoLogradouro(endereco);
                cliente.setEnderecoNumero(endNumero);
                cliente.setEnderecoComplemento(complemento);
                cliente.setSexo(sexo);
                cliente.setCodigo(cod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public static boolean deletarCliente(String cpf) {
        boolean ok = true;
        String query = "delete from cliente where cpf=?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static boolean atualizarCliente(Cliente cliente) {
        boolean ok = true;
        String query = "update cliente set nome=?,email=?,telefone=?,sexo=?,enderecoLogradouro=?,enderecoNumero=?,enderecoComplemento=? where cpf=?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getEnderecoLogradouro());     
            ps.setInt(6, cliente.getEnderecoNumero());
            ps.setString(7, cliente.getEnderecoComplemento());          
            ps.setString(8, cliente.getCpf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
     public static List <Cliente> getClientePorNome(String nomeCli) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente where nome like ?";
        
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nomeCli);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("enderecoLogradouro");
                int endNumero = rs.getInt("enderecoNumero");
                String complemento = rs.getString("enderecoComplemento");
                String sexo = rs.getString("sexo");
                int cod = rs.getInt("codigo");
                
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setCpf(nome);
                cliente.setTelefone(telefone);
                cliente.setEnderecoLogradouro(endereco);
                cliente.setEnderecoNumero(endNumero);
                cliente.setEnderecoComplemento(complemento);
                cliente.setSexo(sexo);
                cliente.setCodigo(cod);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

}
