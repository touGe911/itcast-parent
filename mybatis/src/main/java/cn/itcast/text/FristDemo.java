package cn.itcast.text;

import cn.itcast.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiaotou
 *
 */
public class FristDemo {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            String resource  = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource );
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sessionFactory.openSession();
            User user = sqlSession.selectOne("UserMapper.queryUserById", 1L);
            System.out.println( user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }


    }

}
