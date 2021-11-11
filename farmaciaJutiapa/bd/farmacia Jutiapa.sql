
use test;

drop database bd_farmacia_jutiapa;

create database bd_farmacia_jutiapa;

use bd_farmacia_jutiapa;


/*Genero: femenino o masculino*/
create table genero(
id_genero int NOT NULL AUTO_INCREMENT,
nombre_genero varchar (20) NOT NULL ,
primary key (id_genero)
);

/*Insertar genero*/
insert into genero (nombre_genero) values 
('femenino'), 
('masculino');


/*Estado Civil: soltero, casado, unido, viudo, divorciado*/
create table estado_civil(
id_estado_civil int NOT NULL AUTO_INCREMENT,
abreviatura_estado_civil varchar(3) NOT NULL, 
nombre_estado_civil varchar(20) NOT NULL,
primary key (id_estado_civil) 
);

/*Insertar estado civil*/
insert into estado_civil (abreviatura_estado_civil, nombre_estado_civil) values 
('sol', 'soltero'),
('cas', 'casado'),
('uni', 'unido'),
('viu', 'viudo'),
('div', 'divorciado');


/*Definicion de una persona*/
create table persona(
id_persona int NOT NULL AUTO_INCREMENT ,
primer_nombre varchar(30) NOT NULL ,
segundo_nombre varchar(30) NULL ,
primer_apellido varchar(30) NOT NULL , 
segundo_apellido varchar(30) NULL , 
id_genero int NOT NULL,
fecha_de_nacimiento date NOT NULL ,
id_estado_civil int NOT NULL,
primary key (id_persona),
constraint fk_persona_genero foreign key (id_genero) 
references genero(id_genero) 
on delete cascade 
on update cascade,
constraint fk_persona_estado_civil foreign key (id_estado_civil) 
references estado_civil(id_estado_civil) 
on delete cascade 
on update cascade
);

/*Definicion de una empresa*/
create table empresa(
id_empresa int NOT NULL AUTO_INCREMENT,
nit varchar(20) NOT NULL ,
razonSocial varchar(50) NOT NULL ,
fechaDeConstitucion date NOT NULL,
primary key (id_empresa)
);

/*Proveedores pueden ser persona o empresa*/
create table proveedor(
id_proveedor int NOT NULL AUTO_INCREMENT,
id_empresa int null,
id_persona int null,
primary key (id_proveedor) ,
constraint fk_proveedor_empresa foreign key (id_empresa) 
references empresa(id_empresa) 
on delete cascade 
on update cascade,
constraint fk_proveedor_persona foreign key (id_persona) 
references persona(id_persona) 
on delete cascade 
on update cascade
);

/*Clientes pueden ser persona o empresa*/
create table cliente(
id_cliente int NOT NULL AUTO_INCREMENT,
id_empresa int null,
id_persona int null,
primary key (id_cliente),
constraint fk_cliente_empresa foreign key (id_empresa) 
references empresa(id_empresa) 
on delete cascade 
on update cascade,
constraint fk_cliente_persona foreign key (id_persona) 
references persona(id_persona) 
on delete cascade 
on update cascade
);

/*Tipo de producto: pastillas, unguentos, jarabe, pinzas.*/
create table tipo_producto(
id_tipo_producto int NOT NULL AUTO_INCREMENT,
nombre_tipo_producto varchar(50) NOT NULL,
primary key (id_tipo_producto) 
);

/*Insertar tipo de productos*/
insert into tipo_producto (nombre_tipo_producto) values 
('Líquidos Orales'),
('Gotas'),
('Supositorios'),
('Sólidos Orales'),
('Polvo'),
('Cápsulas de Liberación'),
('Suspensión'),
('Emulsión'),
('Tabletas'),
('Crema'),
('Loción'),
('Caramelo'),
('Gel'),
('Ungüento'),
('Tableta masticable'),
('Spray'),
('Solución'),
('Solución Oftálmica'),
('Gel Oftálmico'),
('Parches'),
('Solución tópica'),
('Crema tópica'),
('Espuma tópica en aerosol');



/*Marca de producto: Pfizer, Moderna, BAYER, */
create table marca_producto(
id_marca_producto int NOT NULL AUTO_INCREMENT,
nombre_marca_producto varchar(50) NOT NULL,
primary key (id_marca_producto)
);

/*Insertar marca de productos*/
insert into marca_producto (nombre_marca_producto) values 
('MERCK'),
('NOVO NORDISK'),
('OCTA PHARMA'),
('GSK'),
('JANSSEN'),
('SENOSIAIN'),
('SCHERING-PLOUGH'),
('SANFER'),
('SANDOZ'),
('GRIFOLS'),
('MSD'),
('NOVARTIS'),
('PFIZER'),
('BAYER'),
('ABBOTT'),
('ROCHE');



/*producto que tenemos */
create table producto(
id_producto int NOT NULL AUTO_INCREMENT,
nombre_producto varchar(20) NOT NULL,
id_tipo_producto int ,
id_marca_producto int ,
primary key (id_producto),
constraint fk_producto_tipo_producto foreign key (id_tipo_producto) 
references tipo_producto(id_tipo_producto) 
on delete cascade 
on update cascade,
constraint fk_producto_marca_producto foreign key (id_marca_producto) 
references marca_producto(id_marca_producto) 
on delete cascade 
on update cascade
);



/*venta */
create table venta(
id_venta int NOT NULL AUTO_INCREMENT,
id_cliente int NOT NULL, 
fecha_venta datetime NOT NULL, 
numero_factura varchar(30) NOT NULL, 
monto_total decimal(18,2) NOT NULL,
primary key (id_venta),
constraint fk_venta_cliente foreign key (id_cliente) 
references cliente(id_cliente) 
on delete cascade 
on update cascade
);


/*venta detalle */
create table venta_detalle(
id_venta_detalle int NOT NULL AUTO_INCREMENT,
id_venta int NOT NULL,
id_marca_producto int NOT NULL,
id_tipo_producto int NOT NULL,
id_producto int NOT NULL,
precio_unitario_venta decimal(18,2) NOT NULL,
cantidad int NOT NULL,
primary key (id_venta_detalle, id_venta),

constraint fk_venta_detalle_venta foreign key (id_venta) references venta(id_venta) on delete cascade on update cascade,

constraint fk_venta_detalle_marca_producto foreign key (id_marca_producto) references marca_producto(id_marca_producto) on delete cascade on update cascade,

constraint fk_venta_detalle_tipo_producto foreign key (id_tipo_producto) references tipo_producto(id_tipo_producto) on delete cascade on update cascade,

constraint fk_venta_detalle_producto foreign key (id_producto) references producto(id_producto) on delete cascade on update cascade

);



/*compra */
create table compra(
id_compra int NOT NULL AUTO_INCREMENT,
id_proveedor int NOT NULL, 
fecha_compra datetime NOT NULL, 
numero_factura varchar(30) NOT NULL, 
monto_total decimal(18,2) NOT NULL,
primary key (id_compra),
constraint fk_compra_proveedor foreign key (id_proveedor) references proveedor(id_proveedor) on delete cascade on update cascade
);


/*compra detalle */
create table compra_detalle(
id_compra_detalle int NOT NULL AUTO_INCREMENT,
id_compra int NOT NULL,
id_marca_producto int NOT NULL,
id_tipo_producto int NOT NULL,
id_producto int NOT NULL,
precio_unitario_compra decimal(18,2) NOT NULL,
cantidad int NOT NULL,
primary key (id_compra_detalle),

constraint fk_compra_detalle_compra foreign key (id_compra) references compra(id_compra) on delete cascade on update cascade,

constraint fk_compra_detalle_marca_producto foreign key (id_marca_producto) references marca_producto(id_marca_producto) on delete cascade on update cascade,

constraint fk_compra_detalle_tipo_producto foreign key (id_tipo_producto) references tipo_producto(id_tipo_producto) on delete cascade on update cascade,

constraint fk_compra_detalle_producto foreign key (id_producto) references producto(id_producto) on delete cascade on update cascade

);

/*oferta de productos */
create table oferta(
id_oferta int NOT NULL AUTO_INCREMENT,
id_marca_producto int NOT NULL,
id_tipo_producto int NOT NULL,
id_producto int NOT NULL,
porcentaje_descuento decimal(5,2) NOT NULL,
fecha_inicio datetime NOT NULL,
fecha_final datetime NOT NULL,
primary key (id_oferta),
constraint fk_oferta_marca_producto foreign key (id_marca_producto) references marca_producto(id_marca_producto) on delete cascade on update cascade,

constraint fk_oferta_tipo_producto foreign key (id_tipo_producto) references tipo_producto(id_tipo_producto) on delete cascade on update cascade,

constraint fk_oferta_producto foreign key (id_producto) references producto(id_producto) on delete cascade on update cascade
);




/*rol*/
create table rol(
id_rol int NOT NULL AUTO_INCREMENT,
nombre_rol varchar(30) NOT NULL,
primary key (id_rol)
);

/*Insertar roles de los usuarios*/
insert into rol (nombre_rol) values 
('jefe de farmacia'), 
('cajero'), 
('bodeguero'), 
('vendedor');



/*usuario*/
create table usuario(
id_usuario int NOT NULL AUTO_INCREMENT,
id_persona int NOT NULL,
contraseña varchar(30) NOT NULL,
id_rol int NOT NULL,
primary key (id_usuario),
constraint fk_usuario_persona foreign key (id_persona) references persona(id_persona) 
on delete cascade on update cascade,
constraint fk_usuario_rol foreign key (id_rol) references rol(id_rol) on delete cascade 
on update cascade 
);


/*acceso*/
create table acceso(
id_acceso int NOT NULL AUTO_INCREMENT,
nombre_acceso varchar(50) NOT NULL,
pagina_acceso varchar(50) NOT NULL,
primary key (id_acceso)
);

/*Insertar accesos de la aplicación*/
insert into acceso (nombre_acceso, pagina_acceso) values 
('Login', 'Login'), 
('Cambio de contraseña', 'ChgPassword'), 
('Logout', 'Logout'), 
('Rol', 'Rol'), 
('Usuario', 'Usuario'), 
('Oferta', 'Oferta'), 
('Compra', 'Compra'), 
('Venta', 'Venta');

/*acceso por rol*/
create table acceso_rol(
id_acceso_rol int NOT NULL AUTO_INCREMENT,
id_acceso int NOT NULL,
id_rol int NOT NULL,
primary key (id_acceso_rol), 
constraint fk_acceso_rol_acceso foreign key (id_acceso) references acceso(id_acceso) 
on delete cascade on update cascade, 
constraint fk_acceso_rol_rol foreign key (id_rol) references rol(id_rol) on delete cascade on update cascade
);

/*Insertar accesos por rol*/
insert into acceso_rol (id_acceso, id_rol) values 
(1, 1), 
(2, 1), 
(3, 1),
(1, 2), 
(2, 2), 
(3, 2);





/*alias*/
create table alias(
id_alias int NOT NULL AUTO_INCREMENT,
alias varchar(30) NOT NULL,
pass varchar(30) NOT NULL,
primary key (id_alias)
);





ALTER TABLE proveedor ADD CONSTRAINT proveedor_unique UNIQUE (id_empresa, id_persona);
ALTER TABLE alias ADD CONSTRAINT alias_unique UNIQUE (alias);
ALTER TABLE acceso_rol ADD CONSTRAINT acceso_rol_unique UNIQUE (id_acceso, id_rol);
ALTER TABLE producto ADD CONSTRAINT producto_unique UNIQUE (nombre_producto, id_tipo_producto, id_marca_producto);
ALTER TABLE genero ADD CONSTRAINT genero_unique UNIQUE (nombre_genero);
ALTER TABLE estado_civil ADD CONSTRAINT estado_civil_unique UNIQUE (nombre_estado_civil);
ALTER TABLE persona ADD CONSTRAINT persona_unique UNIQUE (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido);
ALTER TABLE empresa ADD CONSTRAINT empresa_unique UNIQUE (razonSocial);






/*lote*/
create table lote(
id_lote int NOT NULL AUTO_INCREMENT,
nombre_lote varchar(20) NOT NULL,
fecha_vencimiento datetime NOT NULL, 
primary key (id_lote)
);


/*inventario */
create table inventario(
id_inventario int NOT NULL AUTO_INCREMENT,
id_producto int NOT NULL,
id_lote int NOT NULL,
precio_unitario decimal(18,2) NOT NULL,
cantidad_ingreso int NOT NULL,
cantidad_egreso int NOT NULL,
primary key (id_inventario),
constraint fk_inventario_lote foreign key (id_lote) references lote(id_lote) on delete cascade on update cascade,
constraint fk_inventario_producto foreign key (id_producto) references producto(id_producto) on delete cascade on update cascade
);

