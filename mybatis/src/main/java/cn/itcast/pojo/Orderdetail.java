package cn.itcast.pojo;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaotou
 * @Date: 2018-01-08
 * @Time: 16:27
 */
public class Orderdetail {
    
    private Integer id;
    
    private Double totalPrice;
    
    private Integer status;

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", item=" + item +
                '}';
    }
}
