
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
   private String filial;

    public Produto(String marca, String modelo, int tamanho, int estoque, int codProduto, double valor, String Genero, String filial) {
        this.marca = marca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.estoque = estoque;
        this.codProduto = codProduto;
        this.valor = valor;
        this.Genero = Genero;
        this.filial = filial;
    }

    public Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
