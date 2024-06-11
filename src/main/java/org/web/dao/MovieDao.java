package org.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.entity.Movies;

@Repository
public interface MovieDao extends JpaRepository<Movies, Integer>{

}
