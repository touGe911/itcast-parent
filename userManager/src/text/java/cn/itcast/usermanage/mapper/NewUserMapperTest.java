package cn.itcast.usermanage.mapper;

import cn.itcast.usermanage.pojo.User;
import com.github.abel533.entity.Example;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-15
 * @Time: 17:19
 */
public class NewUserMapperTest {

    public NewUserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(NewUserMapper.class);
    }

    @Test
    /**
     *
     */
    public void testSelectOne() {
        User record = new User();
        // record.setId(1l);
         record.setUserName("zhangsan");
//        record.setPassword("123456");
        System.out.println(this.userMapper.selectOne(record));
    }

    @Test
    public void testSelect() {
        User record = new User();
        record.setPassword("123456");
        System.out.println(this.userMapper.select(record));
    }

    @Test
    public void testSelectCount() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByPrimaryKey() {
        System.out.println(this.userMapper.selectByPrimaryKey(1l));
    }


    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("wukong");
        user.setName("悟空");
        user.setAge(20);
        this.userMapper.insert(user);
    }

    @Test
    public void testInsertSelective() {
        User user = new User();
        user.setUserName("wujing");
        user.setName("悟净");
        user.setAge(20);
        this.userMapper.insertSelective(user);
    }

    @Test
    public void testDelete() {
        User record = new User();
        record.setId(17l);
        record.setUserName("wukong");
        this.userMapper.delete(record);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByPrimaryKey() {
        User record = new User();
        record.setId(19l);
        record.setName("大神");
        record.setUserName("big");
        this.userMapper.updateByPrimaryKey(record);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        User record = new User();
        record.setId(19l);
        record.setName("大神");
        record.setUserName("big");
        this.userMapper.updateByPrimaryKeySelective(record);
    }

    @Test
    public void testSelectCountByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByExample() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("age", 20);
        List<Object> ids = new ArrayList<Object>();
        ids.add(1l);
        ids.add(2l);
        ids.add(3l);
        ids.add(4l);
        criteria.andIn("id", ids);
        Example.Criteria criteria2 = criteria;
        criteria2.andLike("name", "%张%");
        example.or(criteria2);
        example.setOrderByClause(" age asc, id desc");
        List<User> userList = this.userMapper.selectByExample(example);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void text1(){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
//        criteria.andBetween("age",20,30);
        criteria.andGreaterThan("age",20);
        Example.Criteria criteria1 = example.createCriteria();
        criteria1.andLike("name","%张%");
        example.or(criteria1);
        example.setOrderByClause("age desc");
        List<User> userList = this.userMapper.selectByExample(example);
        for (User user : userList) {
            System.out.println(user);
        }

    }


    @Test
    public void testUpdateByExampleSelective() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByExample() {
        fail("Not yet implemented");
    }

}