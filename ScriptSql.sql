create database projetoIntegrador;

use projetoIntegrador;

create table usuario (
id int not null auto_increment primary key,
nome varchar(90) not null,
login varchar(90) not null,
senha varchar(25) not null
);

create table filmes (
id int not null auto_increment primary key,
nome varchar(45),
diretor varchar(45),
anoLancamento varchar(90),
tempoDuracao varchar(90),
status varchar(45),
usuario_id int,
foreign key (usuario_id) references usuario(id)
);

create table series (
id int not null auto_increment primary key,
nome varchar(45),
diretor varchar(45),
anoLancamento varchar(90),
status varchar(45),
usuario_id int,
foreign key (usuario_id) references usuario(id)
);

create table livros (
id int not null auto_increment primary key,
nome varchar(45),
escritor varchar(90),
anoLancamento varchar(90),
status varchar(45),
usuario_id int,
foreign key (usuario_id) references usuario(id)
);

create table jogos (
id int not null auto_increment primary key,
nome varchar(45),
criador varchar(45),
anoLancamento varchar(90),
status varchar(45),
usuario_id int,
foreign key (usuario_id) references usuario(id)
);

