DROP TABLE IF EXISTS users;
CREATE TABLE  users (
    id int not null primary key AUTO_INCREMENT,  #自增
    mobilePhone varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    createDate int(11) not null
);
