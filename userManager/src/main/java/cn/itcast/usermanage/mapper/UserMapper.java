package cn.itcast.usermanage.mapper;

import cn.itcast.usermanage.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-14
 * @Time: 17:15
 */
@Service
public interface UserMapper {

    /**
     * 查询所有
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 分页查询测试
     * @param start
     * @param pageSize
     * @return
     */
    List<User> queryUserByPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    public int addUser(User user);

    /**
     * 删除
     * @param ids
     * @return
     * @throws Exception
     */
    int deleteByIds(@Param("ids") String[] ids)throws Exception;
}
