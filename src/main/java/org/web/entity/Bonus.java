package org.web.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bonusId;
    private Integer bonus;
    private LocalDateTime modifyTime;

    @ManyToOne
    @JoinColumn(name = "paymentId")
    private Payments payments;

    public Bonus() {
    }

    public Bonus(Integer bonusId, Integer bonus, LocalDateTime modifyTime, Payments payments) {
        this.bonusId = bonusId;
        this.bonus = bonus;
        this.modifyTime = modifyTime;
        this.payments = payments;
    }

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
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

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "bonusId=" + bonusId +
                ", bonus=" + bonus +
                ", modifyTime=" + modifyTime +
                ", payments=" + payments +
                '}';
    }
}
