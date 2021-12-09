package br.senac.servlet;

import br.senac.conexaobd.dao.CargoDAO;
import br.senac.conexaobd.dao.FuncionarioDAO;
import br.senac.conexaobd.entidades.Cargo;
import br.senac.conexaobd.entidades.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CargoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         HttpSession sessao = request.getSession();
         List<Cargo> cargo = CargoDAO.getCargo();       
         sessao.setAttribute("cargos", cargo);
         Funcionario funcionario = null;
        if(request.getParameter("cpfUsuario") != null){
           String cpf = request.getParameter("cpfUsuario");
           funcionario = FuncionarioDAO.getFuncionarioPorCPF(cpf);
        }
        request.setAttribute("listaFuncionario", funcionario);
        
        String url ="/protegido/funcionario/cadastroFuncionario.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
