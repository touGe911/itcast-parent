package cn.itcast.usermanage.service.impl;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-14
 * @Time: 21:13
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize) {

        // 在查询方法调用之前，调用分页插件的静态方法，中间最好不要隔任何代码
        PageHelper.startPage(pageNum,pageSize);

        List<User> users = this.userMapper.queryUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(pageInfo.getTotal());
        easyUIResult.setRows(users);

        return easyUIResult;
    }

    @Override
    public void addUsers(User user1, User user2) {
        this.userMapper.addUser(user1);
        // 制造异常
//        int i=1/0;
        this.userMapper.addUser(user2);
    }

    @Override
    public Boolean addUser(User user) throws Exception{
        int count = this.userMapper.addUser(user);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteByIds(String[] ids) throws Exception{

        int count = this.userMapper.deleteByIds(ids);
        if (count>0){
            return true;
        }

        return false;
    }

}
