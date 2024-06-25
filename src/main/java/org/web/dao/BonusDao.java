package org.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.web.entity.Bonus;

import java.time.LocalDateTime;
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

    @Query("SELECT b.bonus FROM Bonus b WHERE b.paymentId = :paymentId")
    Integer findBonusByPaymentId(@Param("paymentId") Integer paymentId);

    @Modifying
    @Transactional

    @Query(value = "INSERT INTO Bonus (bonus, modify_time, payment_id) " +
            "VALUES (:bonus, :modifyTime, :paymentId", nativeQuery = true)
    void insertBonusByPaymentId(@Param("bonus") Integer bonus,
                                @Param("modifyTime")LocalDateTime modifyTime,
                                @Param("paymentId") Integer paymentId);

    @Query(value = "SELECT b.bonus FROM Bonus b WHERE b.paymentId IN " +
                    "(SELECT p.id FROM Payments p WHERE p.orderId = :orderId ORDER BY p.modifyTime DESC LIMIT 1 OFFSET 1)")
    Integer findSecondLatestBonusByOrderId(@Param("orderId") Integer orderId);
}
