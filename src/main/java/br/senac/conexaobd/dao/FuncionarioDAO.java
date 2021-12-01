package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {
    
      public static void inserirFuncionario(Funcionario funcionario) throws SQLException {
        boolean ok = true;
        String query = "insert into funcionario(nome,cpf,email,sexo,telefone,salario,cargo,filial)"
                +"values (?,?,?,?,?,?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3, funcionario.getEmail());
        ps.setString(4, funcionario.getSexo());
        ps.setString(5, funcionario.getTelefone());
        ps.setDouble(6, funcionario.getSalario());
        ps.setString(7, funcionario.getCargo());
        ps.setString(8, funcionario.getFilial());
        ps.execute();
    }

    public static List<Funcionario> getFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "select * from funcionario";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                Double salario = rs.getDouble("salario");
                String cargo = rs.getString("cargo");
                String sexo = rs.getString("sexo");
                int cod = rs.getInt("codFuncionario");
                String filial = rs.getString("filial");

                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setTelefone(telefone);
                funcionario.setSalario(salario);
                funcionario.setCargo(cargo);
                funcionario.setSexo(sexo);
                funcionario.setCodFuncionario(cod);
                funcionario.setFilial(filial);
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public static Funcionario getFuncionarioPorCPF(String cpf) {
        Funcionario funcionario = null;
        String query = "select * from funcionario where cpf=?";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                funcionario = new Funcionario();
                
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Double salario = rs.getDouble("salario");
                String cargo = rs.getString("cargo");
                String sexo = rs.getString("sexo");
                int cod = rs.getInt("codFuncionario");

                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setCpf(cpf);
                funcionario.setTelefone(telefone);
                funcionario.setSalario(salario);
                funcionario.setCargo(cargo);
                funcionario.setSexo(sexo);
                funcionario.setCodFuncionario(cod);

            
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;

    }

    public static boolean deletarFuncionario(String cpf) {
        boolean ok = true;
        String query = "delete from funcionario where cpf=?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static boolean atualizarFuncioanario(Funcionario funcionario) {
        boolean ok = true;
        String query = "update funcionario set nome=?,email=?,telefone=?,salario=?,cargo=?,sexo=?,cpf=? where filial=?";
        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEmail());
            ps.setString(3, funcionario.getTelefone());
            ps.setDouble(4, funcionario.getSalario());
            ps.setString(5, funcionario.getCargo());
            ps.setString(6, funcionario.getSexo());
            ps.setString(7, funcionario.getCpf());
            ps.setString(8, funcionario.getFilial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
     public static Funcionario getUsuario(String login) throws SQLException {

        Funcionario funcionario = null;
        try {
            Connection con = Conexao.getConexao();
            String query = "select * from funcionarios where login =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");

                funcionario = new Funcionario();

                funcionario.setNome(nome);
                funcionario.setLogin(login);
                funcionario.setCargo(cargo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
}
}

    

