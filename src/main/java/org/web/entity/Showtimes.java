package org.web.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Showtimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer movieId;
    private Time time;
    private Date date;

    public Showtimes() {
    }

    public Showtimes(Integer id, Integer movieId, Time time, Date date) {
        this.id = id;
        this.movieId = movieId;
        this.time = time;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Showtimes{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", time=" + time +
                ", date=" + date +
                '}';
    }
}
