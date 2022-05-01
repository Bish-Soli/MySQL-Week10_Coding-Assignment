create database if not exists food;
use food;

drop tables if exists fruit;


create table fruit (
id int(10) not null auto_increment,
name varchar(25) not null,
scientific_name varchar(25) not null,
food_id int(10) not null,
primary key(id),

