package br.senac.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ope = request.getParameter("ope");

        String nome = request.getParameter("nomeCliente");
        String email = request.getParameter("emailCliente");
        String cpf = request.getParameter("cpfCliente");
        String telefone = request.getParameter("telefoneCliente");
        String endereco = request.getParameter("endCliente");
        int ederecoNumero = Integer.parseInt( request.getParameter("nEndCliente"));
        String complemento = request.getParameter("compCliente"); 
       String sexo;

        if (request.getParameter("sexo").equals("masculino")) {
            sexo = "M";
        }else{
            sexo = "F";
        }

        Cliente cliente = new Cliente();
        
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setSexo(sexo);
        cliente.setTelefone(telefone);
        cliente.setEnderecoLogradouro(endereco);
        cliente.setEnderecoNumero(ederecoNumero);
        cliente.setEnderecoComplemento(complemento);
        
        try {
            
            if ("1".equals(ope)) {
                ClienteDAO.atualizarCliente(cliente);
            } else {
                ClienteDAO.inserirCliente(cliente);
            }
            response.sendRedirect(request.getContextPath()+"/protegido/uteis/sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("/protegido/uteis/erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpfUsuario");
        String ope = req.getParameter("ope");
        
        if ("1".equals(ope)) {
            Cliente cliente = ClienteDAO.getClientePorCPF(cpf);
            req.setAttribute("clienteAtualizacao", cliente);
            req.getRequestDispatcher("/protegido/cliente/cadastro.jsp").forward(req, resp);
        } else {
            ClienteDAO.deletarCliente(cpf);
            resp.sendRedirect(req.getContextPath()+"/protegido/cliente/ListarClienteServlet");
        }

    }

}
