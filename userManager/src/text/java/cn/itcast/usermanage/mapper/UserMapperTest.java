package cn.itcast.usermanage.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-14
 * @Time: 19:15
 */
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void queryUserAll() {
        System.out.println(this.userMapper.queryUserAll());

    }
}