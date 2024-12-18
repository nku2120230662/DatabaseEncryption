package demo;

import database.mapper.UserMapper;
import database.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ConnectByMyBatis {
    public void ConnectByMybatis() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> all=mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
