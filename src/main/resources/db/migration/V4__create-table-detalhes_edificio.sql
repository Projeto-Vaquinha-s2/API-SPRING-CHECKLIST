create table detalhes_edificio(
    id bigint not null auto_increment,
    edificio_id bigint not null,
    nome_do_andar varchar(230) not null,
    quantidade_de_andares int not null,
    quantidade_de_garagens int not null,
    quantidade_de_salao_de_festa int not null,
    quantidade_de_guaritas int not null,
    quantidade_de_terracos int not null,

    primary key (id)
)
