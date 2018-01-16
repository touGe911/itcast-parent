package cn.itcast.usermanage.service;

import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-14
 * @Time: 21:13
 */
public interface UserService {
    /**
     * 分页获取用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize);

    /**
     * 测试事务
     * @param user1
     * @param user2
     */
    public void addUsers(User user1, User user2) ;

    /**
     * 新增
     * @param user
     * @return
     * @throws Exception
     */
    Boolean addUser(User user)throws Exception;

    /**
     * 根据ids删除
     * @param ids
     * @return
     * @throws Exception
     */
    Boolean deleteByIds(String[] ids)throws Exception;
}
