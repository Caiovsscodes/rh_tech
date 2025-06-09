create database if not exists rh_tech;
use rh_tech;
	create table if not exists funcionarios(
    id bigint auto_increment primary key,
    nome text not null,
    email text not null unique,
    senha text unique,
    CEP text not null,
    endereco text not null,
    numero  integer not null,
    bairro text not null,
    cidade text not null,
    estado text not null
    );
    create table if not exists Cargos(
    id_Cargo bigint auto_increment primary key,
    nome_Cargo text not null,
    descricao text not null
    );
    select * from funcionarios;
    select * from Cargos;