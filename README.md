# Jersey-api-demo
### 环境配置 
- 安装gradle（Linux环境）
```
curl -s https://get.sdkman.io | bash
sdk install gradle 3.1
gradle -v
```
显示版本号3.1即代表安装成功

- 查看是否有mysql镜像
`docker images`
如果没有执行： 
`docker pull mysql`
如果有直接执行
 
```
docker run -p 3308:3306 --name [容器名] -e MYSQL_ROOT_PASSWORD=[设置mysql密码] -d mysql:latest
```
*注：mysql:latest是你下载的镜像名，若不知道，可执行`docker images`查看镜像版本号*
在3308端口运行mysql

- mybatis配置:打开/src/main/resources.config.properties文件
将`password=123456`的password改成你给mysql设置的密码


- flywayMigrate配置:打开build.gradle文件
将51行的`password=123456`改成你给mysql设置的密码

- 在项目根目录下执行
 ```
 gradle build
 gradle flywayMigrate -i
 ```

- 在项目根目录下执行
`gradle test`
测试数据
`gradle jettyrun` 
运行项目

- 在浏览器中访问 http://localhost:8080/jersey-user-demo/user/email/{email} 
*注：{email}是数据库已经写入的email，例如访问：http://localhost:8080/jersey-user-demo/user/email/565678150@qq.com  就可以返回这个用户的信息*
*如果访问一个数据库中不存在的email，例如访问http://localhost:8080/jersey-user-demo/user/email/123456789@qq.com  返回404，用户不存在*

- 在浏览器中访问 http://localhost:8080/jersey-user-demo/user/mobilePhone/{mobilePhone}
*注：{mobilePhone}是数据库已经写入的mobilePhone，可以通过mobilePhone找到用户*
