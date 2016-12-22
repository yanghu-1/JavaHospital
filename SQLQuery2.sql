create table Charge(
ID varchar(40)references PM(ID),
name varchar(40)not null,
sex varchar(10)not null,
age int not null,
Rname varchar(10)not null,
Tprice int not null)

insert into Charge values('4311','小王','男',21,'鼻科','感冒药',2,300)

/*create table Morders(
 id  varchar(20)references PM(id),
 name varchar(10),
 sex varchar(10),
 age int,
 MName varchar(10),
 num int,
 Fprice int)*/
