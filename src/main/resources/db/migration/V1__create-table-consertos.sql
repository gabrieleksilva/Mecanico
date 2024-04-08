create table consertos(
     id bigint not null auto_increment,
     dt_Entrada varchar(100) not null,
     dt_Saida varchar(100) not null,
     nome varchar(100) not null,
     experiencia varchar(100) not null,
     marca varchar(100) not null,
     modelo varchar(100) not null,
     ano varchar(9) not null,
     primary key(id)
);