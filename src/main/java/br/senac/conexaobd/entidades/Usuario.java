
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

    
public String codificarSenha (String senha){
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }
    
    public boolean validarSenha(String senha){
        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), this.senha);
        return response.verified;
    }
    
    public boolean isGerente(){
        return this.cargo.equalsIgnoreCase("gerente");
    }
    
    public boolean isVendedor(){
        return this.cargo.equalsIgnoreCase("vendedor");
    }    
}
