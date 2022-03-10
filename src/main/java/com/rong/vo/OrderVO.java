package com.rong.vo;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/** 购物车数据的Value Object类 */
public class OrderVO implements Serializable {
    private Integer oid;
    @Column(name = "order_time")
    private Date orderTime;
    private String recvName;
    private String image;
    private String title;
    private Integer price;
    private Integer num;
    private Integer realPrice;
    private Integer totalPrice;

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Integer realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderVO orderVO = (OrderVO) o;
        return Objects.equals(oid, orderVO.oid) && Objects.equals(orderTime, orderVO.orderTime) && Objects.equals(recvName, orderVO.recvName) && Objects.equals(image, orderVO.image) && Objects.equals(title, orderVO.title) && Objects.equals(price, orderVO.price) && Objects.equals(num, orderVO.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, orderTime, recvName, image, title, price, num);
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
