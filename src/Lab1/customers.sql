Drop database jlcindiadb;
Create database jlcindiadb;
Use jlcindiadb;

Create Table customers(
cid int primary key auto_increment,
cname Varchar(20),
email Varchar(20),
phone bigint,
city Varchar(20),
bal double
);