package org.web.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Showtimes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer showtimeId;
    private Integer movieId;
    private Time time;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "screenId")
    private Screen screen;

    public Showtimes() {
    }

    public Showtimes(Integer showtimeId, Integer movieId, Time time, Date date, Screen screen) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.time = time;
        this.date = date;
        this.screen = screen;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "Showtimes{" +
                "showtimeId=" + showtimeId +
                ", movieId=" + movieId +
                ", time=" + time +
                ", date=" + date +
                ", screen=" + screen +
                '}';
    }
}
