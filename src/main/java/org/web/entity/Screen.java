package org.web.entity;

import jakarta.persistence.*;
import org.web.dao.ShowtimeDao;
import org.web.dto.ShowtimeDto;

import java.util.List;

@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String screenName;
    private String screenClass;
    private Integer totalRow;

    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    public Screen() {
    }

    public Screen(Integer id, String screenName, String screenClass, Integer totalRow, Theater theater) {
        this.id = id;
        this.screenName = screenName;
        this.screenClass = screenClass;
        this.totalRow = totalRow;
        this.theater = theater;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", screenName='" + screenName + '\'' +
                ", screenClass='" + screenClass + '\'' +
                ", totalRow=" + totalRow +
                ", theater=" + theater +
                '}';
    }
}
