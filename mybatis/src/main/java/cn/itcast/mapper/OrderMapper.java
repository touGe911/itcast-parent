package cn.itcast.mapper;

import cn.itcast.pojo.Order;
import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: touGe
 * @Date: 2018-01-08
 * @Time: 20:17
 */
public interface OrderMapper {

    /**
     * 查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
     * @param number
     * @return
     */
    public Order queryOrderWithUserDetailWithItem(@Param("number")String number);

    /**
     * 查询订单，查询出下单人信息并且查询出订单详情。
     * @param number
     * @return
     */
    public Order queryOrderWithUserDetail(@Param("number")String number);

    /**
     * 根据订单号查询订单信息，并且查询出下单人信息
     * @param number
     * @return
     */
    public Order queryOrderWithUser(@Param("number")String number);

}
