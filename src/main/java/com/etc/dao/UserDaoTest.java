package com.etc.dao;

import com.etc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    @Test
    public void testSave() throws IOException {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //会话工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

       // session.insert("com.etc.dao.UserDAO.save");
        UserDAO userDAO=session.getMapper(UserDAO.class);
        User user= new User();
        user.setName("jiang2");
        user.setSal(123);
//        userDAO.save(user);
//        System.out.println(user.getId());
//          user.setId(4);
//        userDAO.update(user);
//        userDAO.delect(user);
//        User userquery=userDAO.queryById(user);
//        System.out.println(userquery);

        List<User> list = userDAO.queryByLike("j");
        for (User u:list
             ) {
            System.out.println(u);
        }
        session.commit();
        session.close();
    }
}
