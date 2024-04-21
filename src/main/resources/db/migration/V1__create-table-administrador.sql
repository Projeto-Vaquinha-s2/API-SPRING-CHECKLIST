create table administrador(
    id bigint not null AUTO_INCREMENT,
    nome varchar(230) not null,
    email varchar(135) not null,
    cpf varchar(12) not null,

    primary key(id)
 )