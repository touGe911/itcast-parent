package cn.itcast.springmvc.pojo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaotou
 * @Date: 2018-01-08
 * @Time: 16:27
 */
public class User {

    private String name;
    private Integer age;
    private boolean isMarry;
    private double income;
    private String[] interests;
    private String id;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMarry() {
        return isMarry;
    }

    public void setMarry(boolean marry) {
        isMarry = marry;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarry=" + isMarry +
                ", income=" + income +
                ", interests=" + Arrays.toString(interests) +
                ", id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
