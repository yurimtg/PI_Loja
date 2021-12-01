/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jamile
 * Created: 1 de dez. de 2021
 */

CREATE TABLE venda ( 
codVenda INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 data_venda date not null, 
fk_codcli int not null, 
fk_codFuncionario int not null, 
valor_total decimal not null, 
foreign key (fk_codcli) references cliente (codigo),
 foreign key (fk_codFuncionario) references funcionario (codFuncionario));