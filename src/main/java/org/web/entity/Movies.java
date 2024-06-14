package org.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String title;
    private String titleEnglish;
    private String rating;
    private String runtime;
    private String genre;
    private LocalDate releaseDate;
    private String director;
    private String synopsis;
    private String language;
    private String trailer;
    private String poster;
    private Boolean isOutTheater;

    public Movies() {
    }

    public Movies(Integer movieId, String title, String titleEnglish, String rating, String runtime, String genre, LocalDate releaseDate, String director, String synopsis, String language, String trailer, String poster, Boolean isOutTheater) {
        this.movieId = movieId;
        this.title = title;
        this.titleEnglish = titleEnglish;
        this.rating = rating;
        this.runtime = runtime;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.director = director;
        this.synopsis = synopsis;
        this.language = language;
        this.trailer = trailer;
        this.poster = poster;
        this.isOutTheater = isOutTheater;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Boolean getOutTheater() {
        return isOutTheater;
    }

    public void setOutTheater(Boolean outTheater) {
        isOutTheater = outTheater;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", titleEnglish='" + titleEnglish + '\'' +
                ", rating='" + rating + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", language='" + language + '\'' +
                ", trailer='" + trailer + '\'' +
                ", poster='" + poster + '\'' +
                ", isOutTheater=" + isOutTheater +
                '}';
    }
}
