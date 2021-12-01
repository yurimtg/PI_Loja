/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jamile
 * Created: 1 de dez. de 2021
 */

CREATE TABLE cargo( 
codUsuario integer not null primary key generated always as identity (start with 1, increment by 1), 
usuario varchar(50) not null, 
senha varchar(50) not null, 
nivelAcesso int not null,
fk_codFuncionario int not null,
foreign key (fk_codFuncionario) references funcionario (codFuncionario));