package br.senac.servlet;

import br.senac.conexaobd.dao.FuncionarioDAO;
import br.senac.conexaobd.entidades.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroFuncionarioServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      String ope = request.getParameter("ope");
        
      String filial = request.getParameter("filial");
        String nome = request.getParameter("nomeFuncionario");
        String email = request.getParameter("emailFuncionario");
        String cpf = request.getParameter("cpfFuncionario");
        String telefone = request.getParameter("telefoneFuncionario");
        String salario = request.getParameter("salarioFuncionario");
        String cargo =  request.getParameter("cargoFuncionario");
        String sexo = " ";

        if (request.getParameter("sexo").equals("masculino")) {
            sexo = "M";
        }else{
            sexo = "F";
        }

       Funcionario funcionario = new Funcionario();
        
       funcionario.setFilial(filial);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setSexo(sexo);
        funcionario.setTelefone(telefone);
        funcionario.setSalario(Double.parseDouble(salario));
        funcionario.setCargo(cargo);

        try {
            if ("1".equals(ope)) {
                FuncionarioDAO.atualizarFuncionario(funcionario);
            } else {
                
                FuncionarioDAO.inserirFuncionario(funcionario);
            }
            response.sendRedirect(request.getContextPath() + "/protegido/uteis/sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect(request.getContextPath() + "/protegido/uteis/erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpfUsuario");
        String ope = req.getParameter("ope");
        if ("1".equals(ope)) {
            Funcionario funcionario = FuncionarioDAO.getFuncionarioPorCPF(cpf);
            req.setAttribute("funcionarioAtualizacao", funcionario);
            req.getRequestDispatcher("/protegido/funcionario/cadastroFuncionario.jsp").forward(req, resp);
        } else {
            FuncionarioDAO.deletarFuncionario(cpf);
            resp.sendRedirect(req.getContextPath()+"/protegido/funcionario/ListarFuncionarioServlet");
        }

    }

}
