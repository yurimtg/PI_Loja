package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ItemVenda {

    public ItemVenda() {
    }
    
    private int codItemVenda;
    private int qtd;
    private Double precoUnitario;
    private Double subTotal;
    private String produto;
    private int fkCodVenda;

}
