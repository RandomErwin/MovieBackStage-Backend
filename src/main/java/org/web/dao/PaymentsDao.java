package org.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.web.entity.Payments;

import java.util.List;

@Repository
public interface PaymentsDao extends JpaRepository<Payments, Integer> {

    @Query("SELECT p, b, o, u FROM Payments p " +
            "JOIN Bonus b ON b.paymentId = p.id " +
            "JOIN Orders o ON p.orderId = o.id " +
            "JOIN Users u ON o.userId = u.id " +
            "WHERE p.method = :method")
    List<Object[]>findByMethod(@Param("method") String method);
}
