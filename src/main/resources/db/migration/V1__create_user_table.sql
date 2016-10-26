--#create database
--DROP DATABASE IF EXISTS UserDB;
--CREATE DATABASE UserDB;
--
--#useUserDB
--USE UserDB;

# create user_info_table
DROP TABLE IF EXISTS users;
CREATE TABLE  users (
    id int not null primary key AUTO_INCREMENT,  #自增
    mobilePhone varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null
);
