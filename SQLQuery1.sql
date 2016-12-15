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

create table DLogin(
Did varchar(10)primary key,
Dpwd varchar(10))

create table MLogin(
Mid varchar(10)primary key,
Mpwd varchar(10))

create table PLogin(
Pid varchar(10)primary key,
pwd varchar(10))

create table ALogin(
Pid varchar(10)primary key,
pwd varchar(10))

create table CLogin(
Pid varchar(10)primary key,
pwd varchar(10))





create table YM(
name varchar(10),
sex varchar(10),
age int,
adr varchar(10))

create table PM(
name varchar(10),
sex varchar(10),
age int,
adr varchar(10))

create table NM(
name varchar(10),
sex varchar(10),
age int,
adr varchar(10))

create table BM(
name varchar(10),
sex varchar(10),
age int,
adr varchar(10))



insert into medicine values('�ڿ�','��ðҩ',10,100)
insert into medicine values('Ƥ����','Ƥ��ҩ',20,100)
insert into medicine values('�ۿ�','��ҩ',5,100)
insert into medicine values('�ǿ�','����ҩ',12,100)

