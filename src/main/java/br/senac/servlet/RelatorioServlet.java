package br.senac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RelatorioServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String dataIni = request.getParameter("dataIni");
            String dataFin = request.getParameter("dataFin");
            
        String d = dataIni.substring(0, 2);
        String m = dataIni.substring(3, 5);
        String a = dataIni.substring(6, 10);
        String dataIniForm = a+"-"+m+"-"+d;
        String df = dataFin.substring(0, 2);
        String mf = dataFin.substring(3, 5);
        String af = dataFin.substring(6, 10);
        String dataFinForm = af+"-"+mf+"-"+df;
    }
}
