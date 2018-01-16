package cn.itcast.text;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-08
 * @Time: 19:11
 */
public class UserDaoImplTest {

    private UserDao userDao;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(1l);
        System.out.println(user);
    }

    @Test
    public void queryUserAll() {

        List<User> users = userDao.queryUserAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("颖宝宝");
        user.setPassword("123");
        user.setSex(1);
        user.setAge(30);
        user.setUserName("yingbaobao");
        userDao.insertUser(user);
    }

    @Test
    public void updateUser() {
        User user = userDao.queryUserById(7l);
        user.setAge(18);
        user.setUpdated(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(7l);
    }
}