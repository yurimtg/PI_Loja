package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ItemVenda {

    private int codItemVenda;
    private int qtd;
    private Double precoUnitario;
    private Double subTotal;
    private int fkCodProduto;
    private int fkCodVenda;

}
