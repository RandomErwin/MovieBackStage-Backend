package org.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.web.entity.Orders;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {
    @Query("SELECT o, p, b, u, t, tt, ss, s, st, m FROM Orders o " +
            "JOIN Payments p ON p.orderId = o.id " +
            "JOIN Bonus b ON b.paymentId = p.id " +
            "JOIN Users u ON o.userId = u.id " +
            "JOIN Tickets t ON o.id = t.orderId " +
            "JOIN TicketType tt ON tt.id = t.ticketTypeId " +
            "JOIN SeatStatus ss ON ss.id = t.seatStatusId " +
            "JOIN Seat s ON s.id = ss.seatId " +
            "JOIN Showtimes st ON st.id = ss.showtimeId " +
            "JOIN Movies m ON m.id = st.movieId " +
            "WHERE orderNum = :orderNum AND p.method = :method")
    List<Object[]> findByOrderNumAndMethod(@Param("orderNum")String orderNum, @Param("method")String method);
}
