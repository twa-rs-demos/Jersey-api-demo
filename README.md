# Jersey-api-demo
### 环境配置 
1. 安装gradle（Linux环境）
```
curl -s https://get.sdkman.io | bash
sdk install gradle 3.1
gradle -v
```
显示版本号3.1即代表安装成功

2. 查看是否有mysql镜像
`docker images`
如果没有执行： 
`docker pull mysql`
如果有直接执行

3. 
```
docker run -p 3308:3306 --name [容器名] -e MYSQL_ROOT_PASSWORD=[设置mysql密码] -d mysql:latest
```
*注：mysql:latest是你下载的镜像名，若不知道，可执行`docker images`查看镜像版本号*
在3308端口运行mysql

4. 进入到该项目的根目录下

5. 
```
docker exec -i [容器名或者容器ID] mysql -uroot -p[mysql密码] < src/main/resources/db/migration/initDatabase.sql
```
*注：database/v1_Create_database.sql是项目中的sql文件，其中是对数据库的操作*
显示
```
id	mobilePhone	email	password
1	18829290576	565678150@qq.com	123456789
2	17791378995	357283632@qq.com	123456789
表示数据库写入成功
```

6. 打开/src/main/resources.config.properties文件
将`password=123456`的password改成你给mysql设置的密码

7. 在项目根目录下执行
`gradle build` 
安装包

8. 在项目根目录下执行
`gradle jettyrun` 
运行项目

9. 在浏览器中访问 http://localhost:8080/jersey-user-demo/user/email/{email} 
*注：{email}是数据库已经写入的email，例如访问：http://localhost:8080/jersey-user-demo/user/email/565678150@qq.com  就可以返回这个用户的信息*
*如果访问一个数据库中不存在的email，例如访问http://localhost:8080/jersey-user-demo/user/email/123456789@qq.com  返回404，用户不存在*

10. 在浏览器中访问 http://localhost:8080/jersey-user-demo/user/mobilePhone/{mobilePhone}
*注：{mobilePhone}是数据库已经写入的mobilePhone，可以通过mobilePhone找到用户*
