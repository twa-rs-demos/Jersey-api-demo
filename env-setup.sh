#!/usr/bin/env bash

# create Docker container and create database inside container

BASE_DIR=$(dirname $0)
USER_API=user-api
CONTAINER=assembly_mysql_1

#function createContainer(){
#    docker run -p 3306:3306 --name USER_API -e MYSQL_ROOT_PASSWORD=thoughtworks -d mysql:5.7
#}

function initMysql(){
  echo "the password of root:"
  sql=$(cat $BASE_DIR/mysql-init.sql)
  read -s password
  docker exec -it $CONTAINER mysql -u root -pthoughtworks -e "$sql"
}


# 创建容器

#createContainer

# 初始化数据库，密码是 thoughtworks

initMysql