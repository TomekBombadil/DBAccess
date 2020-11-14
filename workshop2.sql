create database workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use workshop2;

create table users(
    id int primary key not null auto_increment
    ,email varchar(255) unique not null
    ,username varchar(255) not null
    ,password varchar(60) not null
);

insert into users (email, username, password) values (?,?,?);
update users set email=?, username=?, password=? where id=?;
select id, email, username, password from users where id=?;
delete from users where id=?;
select id, email, username, password from users;

