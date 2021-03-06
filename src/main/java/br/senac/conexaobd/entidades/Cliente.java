package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private String nome;
    private String email;
    private String cpf;
    private String sexo;
    private String telefone;
    private String enderecoLogradouro;
    private int enderecoNumero;
    private int codigo;
    private String enderecoComplemento;
    
}
