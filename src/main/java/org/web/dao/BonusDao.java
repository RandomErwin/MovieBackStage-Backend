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
//    @Query("SELECT b FROM Bonus b " +
//            "JOIN b.payments p " +
//            "JOIN p.orders o " +
//            "JOIN o.users u " +
//            "WHERE u.phone = :phone")
//    List<Bonus> findByPhone(@Param("phone") String phone);

    @Query("SELECT b, p, o, t, tt, ss, st, s, m FROM Bonus b " +
            "JOIN Payments p ON b.paymentId = p.id " +
            "JOIN Orders o ON p.orderId = o.id " +
            "JOIN Tickets t ON o.id = t.orderId " +
            "JOIN TicketType tt ON tt.id = t.ticketTypeId " +
            "JOIN SeatStatus ss ON ss.id = t.seatStatusId " +
            "JOIN Seat s ON s.id = ss.seatId " +
            "JOIN Showtimes st ON st.id = ss.showtimeId " +
            "JOIN Movies m ON m.id = st.movieId")
    List<Object[]> findBonus();
}
