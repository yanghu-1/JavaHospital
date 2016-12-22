
create database hospital

create table medicine(
iden varchar(10)primary key,
MName varchar(40),
price int,
num int)

insert into orders values('内科','Wang',20,3000)
insert into orders values('皮肤科','Chen',20,3000)
insert into orders values('眼科','Li',20,3000)
insert into orders values('鼻科','Liu',20,3000)

create table DLogin(
Did varchar(10)primary key,
Dpwd varchar(10))



create table PM(
id varchar(40)primary key,
name varchar(40)not null,
sex varchar(10)not null,
age int not null,
adr varchar(40),
Rname varchar(10)not null)

insert into medicine values('0001','A药',10,100)
insert into medicine values('0002','B药',20,100)
insert into medicine values('0003','C药',5,100)
insert into medicine values('0004','D药',12,100)

create table orders(
Rname varchar(10)primary key,
Doctor varchar(10),
count int,
Tprice int)


create table DLogin(
Did varchar(10)primary key,
Dpwd varchar(10)not null,
name varchar(40)not null)
insert into DLogin values('LI','123','李医生')
insert into DLogin values('zhao','123','赵医生')
insert into DLogin values('Deng','123','邓医生')
insert into DLogin values('Wei','123','魏医生')

create table MLogin(
Mid varchar(10)primary key,
Mpwd varchar(10)not null,
name varchar(40)not null)
insert into MLogin values('Mlogin','123','药师')

create table PLogin(
Pid varchar(10)primary key,
pwd varchar(10)not null,
name varchar(40)not null)
insert into PLogin values('Plogin','123','院长')


create table ALogin(
Pid varchar(10)primary key,
pwd varchar(10)not null,
name varchar(40)not null)
insert into ALogin values('Alogin','123','管理员')

create table CLogin(
Pid varchar(10)primary key,
pwd varchar(10)not null,
name varchar(40)not null)
insert into CLogin values('Clogin','123','收费人员')

create table PM(
id varchar(40)primary key,
name varchar(40)not null,
sex varchar(10) not null,
age int not null,
adr varchar(100),
Rname varchar(10)references medicine(Rname))

insert into medicine values('内科','感冒药',10,100)
insert into medicine values('皮肤科','皮肤药',20,100)
insert into medicine values('眼科','眼药',5,100)
insert into medicine values('鼻科','鼻炎药',12,100)


