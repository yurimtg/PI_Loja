package br.senac.conexaobd.entidades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Venda {
    private int codVenda =0;
    private int fkCli;
    private int fkFuncionario;
    private String dataVenda;
    private Double totalVenda;   
}
