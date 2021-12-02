
package br.senac.conexaobd.entidades;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario {
    
    private String senha;
    private String usuario;
    private int fkCodFuncionario;
    private int nivelAcesso;
    private String cargo;

    public Usuario(){
        
    }

    public Usuario(String senha, String usuario, int fkCodFuncionario, int nivelAcesso, String cargo) {
        this.senha = senha;
        this.usuario = usuario;
        this.fkCodFuncionario = fkCodFuncionario;
        this.nivelAcesso = nivelAcesso;
        this.cargo = cargo;
    }

    public boolean isGerente(){
        return this.cargo.equalsIgnoreCase("gerente");
    }
    
    public boolean isVendedor(){
        return this.cargo.equalsIgnoreCase("vendedor");
    }    
    
    public boolean isAdmin(){
        return this.cargo.equalsIgnoreCase("admin");
    }
}
