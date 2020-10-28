package com.tuling;

import com.github.pagehelper.PageHelper;
import com.tuling.entity.User;
import com.tuling.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            //将XML配置文件构建为Configuration配置类
            reader = Resources.getResourceAsReader(resource);
            // 通过加载配置文件流构建一个SqlSessionFactory  DefaultSqlSessionFactory
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            // 数据源 执行器  DefaultSqlSession
            SqlSession session = sqlMapper.openSession();
            try {
                // 执行查询 底层执行jdbc
                //User user = (User)session.selectOne("com.tuling.mapper.UserMapper.selectById", 1);
                PageHelper.startPage(1, 10);
                UserMapper userMapper = session.getMapper(UserMapper.class);
                User user = userMapper.selectById(1);
                System.out.println(user.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
