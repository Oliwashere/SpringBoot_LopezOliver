create database restaurant_management;

use restaurant_management;

create table Plato(
id INT primary key auto_increment,
nombre VARCHAR(100),
precio DECIMAL,
disponibilidad BOOLEAN
);

create table Mesa(
id INT primary key auto_increment,
numero_mesa INT,
ocupada BOOLEAN
);
