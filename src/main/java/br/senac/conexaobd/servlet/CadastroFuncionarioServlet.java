/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yurim
 */
public class CadastroFuncionarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String ope = request.getParameter("ope");
        
        // Passo 1 - Recuperar os parametros
        String nome = request.getParameter("nomeFuincionario");
        String email = request.getParameter("emailFuincionario");
        String cpf = request.getParameter("cpfFuincionario");
        String telefone = request.getParameter("telefoneFuincionario");
        Double salario = Double.parseDouble(request.getParameter("salarioFuincionario"));
        String cargo =  request.getParameter("cargoFuincionario");
        String sexo = "M";

        if (request.getParameter("sexo").equals("masculino")) {
            sexo = "M";
        }
        if (request.getParameter("sexo").equals("feminino")) {
            sexo = "F";
        }

        // Passo 2 - Inserir no BD
       Funcionario funcionario = new Funcionario();
        
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setSexo(sexo);
        funcionario.setTelefone(telefone);
        funcionario.setSalario(salario);
        funcionario.setCargo(cargo);

        try {
            // ope = 1 => Update
            if ("1".equals(ope)) {
                ClienteDAO.atualizarCliente(funcionario);
            } else {
                ClienteDAO.inserirCliente(funcionario);
            }
            response.sendRedirect(request.getContextPath() + "/uteis/sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect(request.getContextPath() + "/uteis/erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpfUsuario");
        String ope = req.getParameter("ope");
        //OPE = 1 => Atualização
        if ("1".equals(ope)) {
            Cliente cliente = ClienteDAO.getClientePorCPF(cpf);
            req.setAttribute("clienteAtualizacao", cliente);
            req.getRequestDispatcher("/cliente/cadastro.jsp").forward(req, resp);
        } else {
            ClienteDAO.deletarCliente(cpf);
            resp.sendRedirect(req.getContextPath() + "/cliente/ListarClienteServlet");
        }

    }

}
