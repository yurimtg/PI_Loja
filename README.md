# LojaDeTenis
Integrantes: Daniel Oliveira Matheus Alexandre de Costa Castro Jamile Marian Polycarpo Yuri de Oliveira Ignácio

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

CREATE TABLE funcionario(
codFuncionario integer not null primary key generated always as identity (start with 1, increment by 1),
cpf varchar(11) not null,
nome varchar(50) not null,
telefone varchar(20),
salario numeric not null,
cargo varchar(40) not null,
email varchar(40) not null,
sexo char not null);

CREATE TABLE produto(
codProduto integer not null primary key generated always as identity (start with 1, increment by 1),
marca varchar(20) not null,
modelo varchar(30) not null,
tamanho integer not null,
estoque  integer not null,
valor numeric not null,
genero char not null);
