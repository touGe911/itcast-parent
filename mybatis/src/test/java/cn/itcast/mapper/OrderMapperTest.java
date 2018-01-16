package cn.itcast.mapper;

import cn.itcast.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-10
 * @Time: 21:07
 */
public class OrderMapperTest {
    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderWithUserDetailWithItem(){
        System.out.println(this.orderMapper.queryOrderWithUserDetailWithItem("20140921001"));
    }

    @Test
    public void testQueryOrderWithUserDetail(){
        System.out.println(this.orderMapper.queryOrderWithUserDetail("20140921001"));
    }

    @Test
    public void queryOrderWithUser() {
        Order order = this.orderMapper.queryOrderWithUser("20140921001");
        System.out.println(".........");
        String orderNumber = order.getOrderNumber();
        System.out.println(orderNumber);
        System.out.println("-----------------");
        System.out.println(order);
    }
}