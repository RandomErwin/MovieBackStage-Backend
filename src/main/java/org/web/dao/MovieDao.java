package org.web.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.web.entity.Movies;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movies, Integer>{

//    @Query("SELECT m FROM Movies m WHERE m.isPlaying = True")
//    List<Movies> findMoviesByIsPlayingTrue();
//
//    @Query("SELECT m FROM Movies m WHERE m.releaseDate > :today AND m.isPlaying = false")
//    List<Movies> findMoviesByReleaseDateAfterAndIsPlayingFalse(@Param("today")LocalDate today);
//
//    @Query("SELECT m FROM Movies m WHERE m.releaseDate < :today AND m.isPlaying = false")
//    List<Movies> findMoviesByReleaseDateBeforeAndIsPlayingFalse(@Param("today")LocalDate today);

    @Query("SELECT m FROM Movies m WHERE m.releaseDate > :today AND m.isOutTheater = false")
    List<Movies> findMoviesByReleaseDateAfterAndIsOutTheaterFalse(@Param("today")LocalDate today);

    @Query("SELECT m FROM Movies m WHERE m.releaseDate <= :today AND m.isOutTheater = false")
    List<Movies> findMoviesByReleaseDateBeforeAndIsOutTheaterFalse(@Param("today")LocalDate today);

    @Modifying
    @Transactional
    @Query("UPDATE Movies m SET m.isOutTheater = true WHERE m.id = ?1")
    int updateMovieById(Integer id);

}
