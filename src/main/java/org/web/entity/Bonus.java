package org.web.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer bonus;
    private LocalDateTime modifyTime;
    private Integer paymentId;

    public Bonus() {
    }

    public Bonus(Integer id, Integer bonus, LocalDateTime modifyTime, Integer paymentId) {
        this.id = id;
        this.bonus = bonus;
        this.modifyTime = modifyTime;
        this.paymentId = paymentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "id=" + id +
                ", bonus=" + bonus +
                ", modifyTime=" + modifyTime +
                ", paymentId=" + paymentId +
                '}';
    }
}
