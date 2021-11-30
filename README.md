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

CREATE TABLE cargo(
codCargo integer not null primary key generated always as identity (start with 1, increment by 1),
cargo varchar(50) not null,);


 
CREATE TABLE cargo(
codUsuario integer not null primary key generated always as identity (start with 1, increment by 1),
usuario varchar(50) not null,
senha varchar(50) not null,
nivelAcesso int not null,
fk_codFuncionario int not null,
foreign key (fk_codFuncionario) references funcionario (codFuncionario));


CREATE TABLE venda (
codVenda INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
data_venda date not null,
fk_codcli int not null,
fk_codFuncionario int not null,
valor_total decimal not null,
foreign key (fk_codcli) references cliente (codigo),
foreign key (fk_codFuncionario) references funcionario (codFuncionario)); 

CREATE TABLE itemVenda (
codItemVenda INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
qtd int not null,
precoUnitario decimal not null,
subTotal decimal not null,
fk_codProduto int not null,
fk_codVenda int not null,
foreign key (fk_codProduto ) references produto (codProduto),
foreign key (fk_codVenda) references venda (codVenda)); 
ex:
INSERT INTO venda (data_venda,fk_codCli,fk_codfuncionario,valor_total) values('2021-11-21', 216,3,452);


