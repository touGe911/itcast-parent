package cn.itcast.springmvc.pojo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-12
 * @Time: 18:45
 */
public class UsersVO {
    private List<User> users;

    @Override
    public String toString() {
        return "UsersVO{" +
                "users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
