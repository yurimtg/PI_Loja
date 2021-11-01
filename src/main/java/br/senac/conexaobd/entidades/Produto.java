
package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Produto {
   private String marca;
   private String modelo;
   private int tamanho;
   private int estoque;
   private int codProduto;
   private  double valor;
   private String Genero;
}
