package cn.itcast.text;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-08
 * @Time: 19:11
 */
public class UserMapperTest {

    private UserMapper userMapper;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void testQueryUserListByIds(){
        List<User> users = this.userMapper.queryUserListByIds(new Long[]{1l,2l,3l,4l});
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUserSelective(){
        User user = new User();
        user.setAge(18);
        user.setName("柳岩");
        user.setPassword("123456");
        user.setUserName("yanyan2");
//		user.setSex(3);
        user.setBirthday(new Date());
        user.setId(8l);
        this.userMapper.updateUserSelective(user);
    }

    @Test
    public void queryUserListLikeUserNameAndAge(){
        List<User> users = this.userMapper.queryUserListLikeUserNameAndAge("", 20);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void queryUserListLikeUserNameOrAge(){
        List<User> users = this.userMapper.queryUserListLikeUserNameOrAge("", 20);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void queryManUserListLikeUserName(){

        List<User> users = this.userMapper.queryManUserListLikeUserName("zhang");
        for (User user : users) {
            System.out.println("user = " + user);
        }

    }

    @Test
    public void queryUserLikeUserName(){
        List<User> users = this.userMapper.queryUserLikeUserName("zhang");
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }


    @Test
    public void loginMap(){
        Map<String, Object> map = new HashMap<>();
        User user = this.userMapper.queryUserById(1L);
        /*map.put("userName","zhangsan");
        map.put("password","123456");*/
        map.put("user",user);
        User zhangsan = this.userMapper.loginMap(map);
        System.out.println("zhangsan = " + zhangsan);
    }


    @Test
    public void login(){
        User zhangsan = this.userMapper.login("zhangsan", "123456");
        System.out.println("zhangsan = " + zhangsan);
    }

    @Test
    public void queryUserByTableName(){
        List<User> users = this.userMapper.queryUserByTableName("tb_user");
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void queryUserById() {
        User user = userMapper.queryUserById(1l);
        System.out.println(user);
    }

    @Test
    public void queryUserAll() {

        List<User> users = userMapper.queryUserAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("热巴姐姐");
        user.setPassword("123");
        user.setSex(1);
        user.setAge(18);
        user.setUserName("reba");
        userMapper.insertUser(user);
        System.out.println(user.getId());

    }

    @Test
    public void updateUser() {
        User user = userMapper.queryUserById(7l);
        user.setAge(18);
        user.setUpdated(new Date());
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userMapper.deleteUserById(7l);
    }
}