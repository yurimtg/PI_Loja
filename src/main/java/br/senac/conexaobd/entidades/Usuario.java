
package br.senac.conexaobd.entidades;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
    
    
    public String codificarSenha(String senha){
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }
 
    public boolean validarSenha(String senha){
        BCrypt.Result resposta = BCrypt.verifyer().verify(senha.toCharArray(), this.senha);
        return resposta.verified;
        
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
