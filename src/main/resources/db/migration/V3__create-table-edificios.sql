create table edificio(
    id bigint not null AUTO_INCREMENT,
    nome varchar(230) not null,
    cnpj varchar(15) not null,
    endereco varchar(230),

    primary key (id)
)