package org.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer unitPrice;
    private String ticketType;

    public TicketType() {
    }

    public TicketType(Integer id, Integer unitPrice, String ticketType) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.ticketType = ticketType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", unitPrice=" + unitPrice +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}
