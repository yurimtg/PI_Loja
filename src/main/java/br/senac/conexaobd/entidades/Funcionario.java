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

    public Funcionario(String nome, String email, String cpf, String sexo, String telefone, double salario, String cargo, int codFuncionario, String login, String filial) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
        this.codFuncionario = codFuncionario;
        this.login = login;
        this.filial = filial;
    }
    
    public Funcionario(){
        
    }
    
    public boolean isGerente(){
        return "gerente".equalsIgnoreCase(this.cargo);
    }
    
    public boolean isVendedor(){
        return "vendedor".equalsIgnoreCase(this.cargo);
    }    
    
    public boolean isDiretor(){
        return "diretor".equalsIgnoreCase(this.cargo);
    }
}
