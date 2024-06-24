package org.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.web.entity.Payments;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentsDao extends JpaRepository<Payments, Integer> {

    @Query("SELECT p, b, o, u FROM Payments p " +
            "JOIN Bonus b ON b.paymentId = p.id " +
            "JOIN Orders o ON p.orderId = o.id " +
            "JOIN Users u ON o.userId = u.id " +
            "WHERE p.method = :method")
    List<Object[]>findByMethod(@Param("method") String method);

    // 退款機制 => 根據已存在的 row data 產生一筆新資料
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Payments (order_id, payway, pay_status, pay_time, method, modify_time) " +
            "SELECT p.order_id, p.payway, p.pay_status, p.pay_time, 'refund', :modify_time FROM Payments p " +
            "WHERE p.order_id = (SELECT o.id FROM Orders o WHERE o.order_num = :order_num)", nativeQuery = true)
    void insertRefundPaymentByOrderNum(@Param("order_num") String OrderNum, @Param("modify_time") LocalDateTime modifyTime);
}
