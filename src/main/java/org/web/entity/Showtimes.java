package org.web.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class Showtimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer movieId;
    private LocalDateTime showTime;

    public Showtimes() {
    }

    public Showtimes(Integer id, Integer movieId, LocalDateTime showTime) {
        this.id = id;
        this.movieId = movieId;
        this.showTime = showTime;
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

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "Showtimes{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", showTime=" + showTime +
                '}';
    }
}
