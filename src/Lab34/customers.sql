Drop database jlcindiadb;
Create database jlcindiadb;
Use jlcindiadb;

-- Table Required --
Create Table customers(
cid int primary key auto_increment,
cname Varchar(20),
email Varchar(55),
city Varchar(25),
cardBal double,
cardType Varchar(10),
cardNo int,
status Varchar(10)
);


-- INSERT Some Sample Records --
INSERT into customers values(101,'Sri','sri@gmail.com','Blore',20000,'VISA',1234,'ACTIVE');
INSERT into customers values(102,'Dev','dev@gmail.com','Blore',30000,'VISA',1235,'ACTIVE');
INSERT into customers values(103,'aa','aa@gmail.com','Blore',10000,'VISA',1236,'ACTIVE');
INSERT into customers values(104,'bb','bb@gmail.com','Delhi',10000,'VISA',1237,'ACTIVE');
INSERT into customers values(105,'cc','cc@gmail.com','Delhi',35000,'MASTER',1238,'ACTIVE');
INSERT into customers values(106,'dd','dd@gmail.com','Hyd',45000,'MASTER',1239,'ACTIVE');
INSERT into customers values(107,'ee','ee@gmail.com','Blore',25000,'VISA',1240,'INACTIVE');
INSERT into customers values(108,'ff','ff@gmail.com','Hyd',25000,'VISA',1241,'ACTIVE');