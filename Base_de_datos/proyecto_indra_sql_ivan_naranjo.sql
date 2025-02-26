-- proyecto indra
-- creado por Iván Naranjo
drop database if exists portaleventos;
create database portaleventos;
use portaleventos;

-- tabla de usuarios
create table usuarios (
    id int auto_increment primary key,
    nombre varchar(30) not null,
    email varchar(40) unique not null,
    password varchar(25) not null
);

-- tabla de organizadores
create table organizadores (
    id int auto_increment primary key,
    nombre varchar(30) not null,
    contacto varchar(50) not null
);

-- tabla de categorías
create table categorias (
    id int auto_increment primary key,
    nombre varchar(30) not null unique
);

-- tabla de ubicaciones
create table ubicaciones (
    id int auto_increment primary key,
    direccion varchar(35) not null,
    tipo enum('online', 'presencial') not null
);

-- tabla de eventos
create table eventos (
    id int auto_increment primary key,
    nombre varchar(30) not null,
    fecha date not null,
    duracion int not null,
    organizador_id int,
    categoria_id int,
    ubicacion_id int,
    foreign key (organizador_id) references organizadores(id) on delete set null,
    foreign key (categoria_id) references categorias(id) on delete set null,
    foreign key (ubicacion_id) references ubicaciones(id) on delete set null
);

-- tabla de inscripciones
create table inscripciones (
    id int auto_increment primary key,
    usuario_id int,
    evento_id int,
    fecha_inscripcion date,
    foreign key (usuario_id) references usuarios(id) on delete cascade,
    foreign key (evento_id) references eventos(id) on delete cascade
);
