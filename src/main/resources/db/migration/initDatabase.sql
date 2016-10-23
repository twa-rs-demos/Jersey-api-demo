#create database
DROP DATABASE IF EXISTS UserDB;
CREATE DATABASE UserDB;

#useUserDB
USE UserDB;

# create user_info_table
DROP TABLE IF EXISTS  users;
CREATE TABLE  users (
    id int not null primary key AUTO_INCREMENT,  #自增
    mobilePhone varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null
);

# insert some user information into table
INSERT INTO users(mobilePhone, email, password) VALUES( "18829290576", "565678150@qq.com", "123456789");
INSERT INTO users(mobilePhone, email, password) VALUES( "17791378995", "357283632@qq.com", "123456789");

# show all user information from users
SELECT * FROM UserDB.users;
