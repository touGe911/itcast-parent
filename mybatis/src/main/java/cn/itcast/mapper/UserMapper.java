package cn.itcast.mapper;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-08
 * @Time: 20:17
 */
public interface UserMapper {

    /**
     * 根据多个id查询用户信息
     * @param ids
     * @return
     */
    public List<User> queryUserListByIds(@Param("ids")Long[] ids);


    /**
     * 修改用户信息，如果参数user中的某个属性为null，则不修改。
     * @param user
     */
    public void updateUserSelective(User user);

    /**
     * 查询所有用户，如果输入了用户名按照用户名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。
     * @param userName
     * @param age
     * @return
     */
    public List<User> queryUserListLikeUserNameAndAge(@Param("userName")String userName, @Param("age")Integer age);

    /**
     * 查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
     * @param userName
     * @param age
     * @return
     */
    public List<User> queryUserListLikeUserNameOrAge(@Param("userName")String userName,@Param("age")Integer age);


    /**
     * 查询男性用户，如果输入了用户名，按用户名模糊查询
     * @param userName
     * @return
     */
    public List<User> queryManUserListLikeUserName(@Param("userName")String userName);


    /**
     * 模糊查询
     * @param userName
     * @return
     */
    public List<User> queryUserLikeUserName(@Param("userName") String userName);

    /**
     * c测试传入map集合参数
     * @param map
     * @return
     */
    public User loginMap(Map<String,Object> map);

    /**
     * 登陆，测试同时传入2个参数
     * @param userName
     * @param Password
     */
    public User login(@Param("userName") String userName,@Param("password") String Password);

    /**
     * 根据表名进行查询
     */
    public List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);


    public void deleteUserById(Long id);

}
