/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.servlet;

import br.senac.conexaobd.dao.FuncionarioDAO;
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

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      String ope = request.getParameter("ope");
        
        // Passo 1 - Recuperar os parametros
        String nome = request.getParameter("nomeFuincionario");
        String email = request.getParameter("emailFuincionario");
        String cpf = request.getParameter("cpfFuincionario");
        String telefone = request.getParameter("telefoneFuincionario");
        Double salario = Double.parseDouble(request.getParameter("salarioFuincionario"));
        String cargo =  request.getParameter("cargoFuincionario");
        String sexo = "";

        if (request.getParameter("sexo").equals("masculino")) {
            sexo = "M";
        }else{
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
                FuncionarioDAO.atualizarFuncioanario(funcionario);
            } else {
                
                FuncionarioDAO.inserirFuncionario(funcionario);
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
            Funcionario funcionario = FuncionarioDAO.getFuncionarioPorCPF(cpf);
            req.setAttribute("funcionarioAtualizacao", funcionario);
            req.getRequestDispatcher("/funcionario/cadastroFuncionario.jsp").forward(req, resp);
        } else {
            FuncionarioDAO.deletarFuncionario(cpf);
            resp.sendRedirect(req.getContextPath() + "/funcionario/ListarFuncionarioServlet");
        }

    }

}
