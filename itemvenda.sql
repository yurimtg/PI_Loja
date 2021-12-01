/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jamile
 * Created: 1 de dez. de 2021
 */

CREATE TABLE itemVenda ( 
codItemVenda INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
qtd int not null, 
precoUnitario decimal not null, 
subTotal decimal not null, 
fk_codProduto int not null, 
fk_codVenda int not null, foreign key (fk_codProduto ) references produto (codProduto), 
foreign key (fk_codVenda) references venda (codVenda)); 
