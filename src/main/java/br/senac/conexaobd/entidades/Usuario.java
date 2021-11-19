
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
}
