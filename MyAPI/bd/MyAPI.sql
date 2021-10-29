
use test;

drop database myapi;

create database myapi;

use myapi;


/*rol*/
create table rol(
id_rol int NOT NULL AUTO_INCREMENT,
nombre_rol varchar(30) NOT NULL,
primary key (id_rol)
);
