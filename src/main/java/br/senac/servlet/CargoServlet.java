package br.senac.servlet;

import br.senac.conexaobd.dao.CargoDAO;
import br.senac.conexaobd.entidades.Cargo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CargoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List<Cargo> cargo = CargoDAO.getCargo();
        request.setAttribute("cargos", cargo);
        
         String url ="/protegido/funcionario/cadastroFuncionario.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
