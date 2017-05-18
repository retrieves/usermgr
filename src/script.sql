drop database if exists usermgr;
create database usermgr;
use usermgr;
create table user(
	id int primary key auto_increment,
	name varchar(20) not null,
	sex  varchar(8) not null,
	birthday date
);