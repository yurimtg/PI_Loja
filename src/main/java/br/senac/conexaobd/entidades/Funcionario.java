package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Funcionario {
    
    private String nome;
    private String email;
    private String cpf;
    private String sexo;
    private String telefone;
    private double salario;
    private String cargo;
    private int codFuncionario;
    private String login;   
    private String filial;
}
