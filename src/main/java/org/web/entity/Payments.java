package org.web.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String payway;
    private String payStatus;
    private Date payTime;
    private String method;
    private Date modifyTime;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;

    public Payments() {
    }

    public Payments(Integer paymentId, String payway, String payStatus, Date payTime, String method, Date modifyTime, Orders orders) {
        this.paymentId = paymentId;
        this.payway = payway;
        this.payStatus = payStatus;
        this.payTime = payTime;
        this.method = method;
        this.modifyTime = modifyTime;
        this.orders = orders;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentId=" + paymentId +
                ", payway='" + payway + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", payTime=" + payTime +
                ", method='" + method + '\'' +
                ", modifyTime=" + modifyTime +
                ", orders=" + orders +
                '}';
    }
}
