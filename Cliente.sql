/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jamile
 * Created: 1 de dez. de 2021
 */

CREATE TABLE cliente( 
codigo integer not null primary key generated always as identity (start with 1, increment by 1), 
cpf varchar(11) not null,
 nome varchar(50) not null, 
telefone varchar(20), 
enderecoLogradouro varchar(50), 
enderecoNumero varchar(20),
 enderecoComplemento varchar(50), 
email varchar(40) not null, 
sexo char not null);