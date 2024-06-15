package org.web.entity;

import jakarta.persistence.*;

@Entity
public class SeatStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

    private Integer seatId;

    private Integer showtimeId;

    public SeatStatus() {
    }

    public SeatStatus(Integer id, String status, Integer seatId, Integer showtimeId) {
        this.id = id;
        this.status = status;
        this.seatId = seatId;
        this.showtimeId = showtimeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    @Override
    public String toString() {
        return "SeatStatus{" +
                "id=" + id +
                ", status=" + status +
                ", seatId=" + seatId +
                ", showtimeId=" + showtimeId +
                '}';
    }
}
