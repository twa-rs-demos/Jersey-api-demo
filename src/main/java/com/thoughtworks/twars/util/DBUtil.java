package com.thoughtworks.twars.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
    public static SqlSessionManager getSession() {
        String resource = "mybatis/mybatis-config.xml";
        SqlSessionManager session = null;

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            session = SqlSessionManager.newInstance(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }

    public static SqlSessionManager getSession(String environment) {
        String resource = "mybatis/mybatis-config.xml";
        SqlSessionManager session = null;

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is, environment);
            session = SqlSessionManager.newInstance(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }
}
