create table registro_fotografico_edificio(
                                  id bigint not null auto_increment,
                                  edificio_id bigint not null,
                                  foto blob,
                                  data_da_foto varchar(120) not null,
                                  descricao varchar(230) not null,
                                  categorizacao int not null

                                  primary key (id)
)

alter table registro_fotografico_edificio
    add constraint fk_edificio
        foreign key (edificio_id) references edificio(id);