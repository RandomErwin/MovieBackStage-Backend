package org.web.entity;

import jakarta.persistence.*;
import org.hibernate.query.Order;

@Entity
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ticketTypeId;

    private Integer showtimeId;

    private Integer seatStatusId;

    private Integer orderId;

    public Tickets() {
    }

    public Tickets(Integer id, Integer ticketTypeId, Integer showtimeId, Integer seatStatusId, Integer orderId) {
        this.id = id;
        this.ticketTypeId = ticketTypeId;
        this.showtimeId = showtimeId;
        this.seatStatusId = seatStatusId;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Integer getSeatStatusId() {
        return seatStatusId;
    }

    public void setSeatStatusId(Integer seatStatusId) {
        this.seatStatusId = seatStatusId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", ticketTypeId=" + ticketTypeId +
                ", showtimeId=" + showtimeId +
                ", seatStatusId=" + seatStatusId +
                ", orderId=" + orderId +
                '}';
    }
}
