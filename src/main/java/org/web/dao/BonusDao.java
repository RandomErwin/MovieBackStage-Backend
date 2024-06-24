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
    // 順序 ＋ join 列數 = Dto 屬性順序＋容器數量
    @Query("SELECT b, p, o, u FROM Bonus b " +
            "JOIN Payments p ON b.paymentId = p.id " +
            "JOIN Orders o ON p.orderId = o.id " +
            "JOIN Users u ON o.userId = u.id")
    List<Object[]> findBonus();

    @Query(value = "INSERT INTO Bonus (bonus, modify_time, payment_id) " +
            "SELECT ")
    void insertBonusByPaymentId(@Param("method") String method);
}
