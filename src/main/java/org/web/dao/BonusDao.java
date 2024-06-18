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
    @Query("SELECT b, p, o, u, t, tt, ss, s, st, m FROM Bonus b " +
            "JOIN Payments p ON b.paymentId = p.id " +
            "JOIN Orders o ON p.orderId = o.id " +
            "JOIN Users u ON o.userId = u.id " +
            "JOIN Tickets t ON o.id = t.orderId " +
            "JOIN TicketType tt ON tt.id = t.ticketTypeId " +
            "JOIN SeatStatus ss ON ss.id = t.seatStatusId " +
            "JOIN Seat s ON s.id = ss.seatId " +
            "JOIN Showtimes st ON st.id = ss.showtimeId " +
            "JOIN Movies m ON m.id = st.movieId " +
            "WHERE orderNum = :orderNum")
    List<Object[]> findByOrderNum(@Param("orderNum")String orderNum);
}
