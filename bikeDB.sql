CREATE SCHEMA `bikes` ;

use bikes;

drop table if exists bikes;

create table bikes (
	id int(10) not null auto_increment,
	brand varchar(25),
	niche varchar(25),
	model_name varchar(25),
	price int(10),
	primary key(id)
);