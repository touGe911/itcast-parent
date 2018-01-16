package cn.itcast.dao;

import cn.itcast.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-08
 * @Time: 17:11
 */
public interface UserDao {

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

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);


}
