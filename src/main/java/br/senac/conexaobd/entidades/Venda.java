package br.senac.conexaobd.entidades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Venda {
    private int codVenda;
    private String nomeCli;
    private String nomeFuncionario;
    private String dataVenda;
    private Double totalVenda;  
    private String pagamento;
    private String filial;
}
