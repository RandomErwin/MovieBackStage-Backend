package org.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.web.entity.Bonus;

import java.util.List;

@Repository
public interface BonusDao extends JpaRepository<Bonus, Integer> {

    // 注意要留空白的位置
    @Query("SELECT b FROM Bonus b " +
            "JOIN b.payments p " +
            "JOIN p.orders o " +
            "JOIN o.users u " +
            "WHERE u.phone = :phone")
    List<Bonus> findByPhone(@Param("phone") String phone);
}
