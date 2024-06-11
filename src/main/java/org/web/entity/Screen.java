package org.web.entity;

import jakarta.persistence.*;
import org.web.dao.ShowtimeDao;
import org.web.dto.ShowtimeDto;

import java.util.List;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screenId;
    private String screenName;
    private String screenClass;
    private Integer totalRow;

    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Showtimes> showtimes;

    public Screen() {
    }

    public Screen(Integer screenId, String screenName, String screenClass, Integer totalRow, Theater theater, List<Showtimes> showtimes) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.screenClass = screenClass;
        this.totalRow = totalRow;
        this.theater = theater;
        this.showtimes = showtimes;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenClass() {
        return screenClass;
    }

    public void setScreenClass(String screenClass) {
        this.screenClass = screenClass;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Showtimes> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtimes> showtimes) {
        this.showtimes = showtimes;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId=" + screenId +
                ", screenName='" + screenName + '\'' +
                ", screenClass='" + screenClass + '\'' +
                ", totalRow=" + totalRow +
                ", theater=" + theater +
                ", showtimes=" + showtimes +
                '}';
    }
}
