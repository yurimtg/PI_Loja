
package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CargoDAO {
 
    public static List<Cargo> getCargo() {
        List<Cargo> cargos = new ArrayList<>();
        String query = "select * from cargo";

        Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                String car = rs.getString("cargo");
                int codCargo = rs.getInt("codCargo");


                cargo.setCargo(car);
                cargo.setCodCargo(codCargo);

                cargos.add(cargo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }
    
}
