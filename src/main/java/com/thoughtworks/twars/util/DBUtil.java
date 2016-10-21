package com.thoughtworks.twars.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
    public static SqlSessionFactory  sqlSessionFactory = null;
        static {
        try {
            //将配置文件读取到输入流中
            String resource = "mybatis/mybatis-config.xml";
            InputStream reader = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory对象，解析reader对象中的内容,利用反射创建SqlSessionFactory对象.
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionManager getSession(){
        return SqlSessionManager.newInstance(sqlSessionFactory);
    }  //开启数据库并且获得用户身份

    public static void closeSession(SqlSession session){
        if(session != null){
            session.close();  //数据库可以接受访问的人数是有限的，因此每次访问完数据库必须断开和数据库的链接，关闭数据库
        }
    }
}
