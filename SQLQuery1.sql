create database hospital

create table medicine(
Rname varchar(10)primary key,
MName varchar(10),
price int,
num int)

create table orders(
Rname varchar(10)references medicine(Rname),
Doctor varchar(10),
count int,
Tprice int,
primary key(Rname))

insert into orders values('ÄÚ¿Æ','Wang',20,3000)
insert into orders values('Æ¤·ô¿Æ','Chen',20,3000)
insert into orders values('ÑÛ¿Æ','Li',20,3000)
insert into orders values('±Ç¿Æ','Liu',20,3000)

create table DLogin(
Did varchar(10)primary key,
Dpwd varchar(10))

create table MLogin(
Mid varchar(10)primary key,
Mpwd varchar(10))

create table PLogin(
Pid varchar(10)primary key,
pwd varchar(10))

insert into PLogin values('plogin','123')

create table ALogin(
Pid varchar(10)primary key,
pwd varchar(10))

create table CLogin(
Pid varchar(10)primary key,
pwd varchar(10))

insert into CLogin values('clogin','123')

create table PM(
id varchar(20)primary key,
name varchar(10),
sex varchar(10),
age int,
adr varchar(10),
Rname varchar(10)references medicine(Rname))

insert into medicine values('ÄÚ¿Æ','¸ÐÃ°Ò©',10,100)
insert into medicine values('Æ¤·ô¿Æ','Æ¤·ôÒ©',20,100)
insert into medicine values('ÑÛ¿Æ','ÑÛÒ©',5,100)
insert into medicine values('±Ç¿Æ','±ÇÑ×Ò©',12,100)

