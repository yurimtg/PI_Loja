package br.senac.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vCod[] = req.getParameter("codigo").split(",");
        String vModelo[] = req.getParameter("modelo").split(",");
        String vValor[] = req.getParameter("valor").split(",");
        String vQtd[] = req.getParameter("qtd").split(",");
        String vTotal[] = req.getParameter("total").split(",");
                
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date =  new Date();
                
                String data = sdf.format(date);
                


    }

}
