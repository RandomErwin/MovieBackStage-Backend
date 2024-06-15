package org.web.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String payway;
    private String payStatus;
    private Date payTime;
    private String method;
    private Date modifyTime;
    private Integer orderId;

    public Payments() {
    }

    public Payments(Integer id, String payway, String payStatus, Date payTime, String method, Date modifyTime, Integer orderId) {
        this.id = id;
        this.payway = payway;
        this.payStatus = payStatus;
        this.payTime = payTime;
        this.method = method;
        this.modifyTime = modifyTime;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", payway='" + payway + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", payTime=" + payTime +
                ", method='" + method + '\'' +
                ", modifyTime=" + modifyTime +
                ", orderId=" + orderId +
                '}';
    }
}
