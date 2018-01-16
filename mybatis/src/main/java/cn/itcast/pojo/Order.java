package cn.itcast.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaotou
 * @Date: 2018-01-08
 * @Time: 16:27
 */
public class Order {

    private Integer id;

    private Long userId;

    private String orderNumber;

    private User user;

    private List<Orderdetail> detailList;

    public List<Orderdetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Orderdetail> detailList) {
        this.detailList = detailList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNumber='" + orderNumber + '\'' +
                ", user=" + user +
                ", detailList=" + detailList +
                '}';
    }
}
