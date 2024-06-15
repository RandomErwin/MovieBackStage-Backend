package org.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.dao.BonusDao;
import org.web.dto.BonusDto;
import org.web.dto.Result;
import org.web.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BonusService {

    private final BonusDao bonusDao;

    public BonusService(BonusDao bonusDao) {
        this.bonusDao = bonusDao;
    }

    public List<BonusDto> getBonus(){
        List<Object[]> results = bonusDao.findBonus();
        List<BonusDto> bonusDtos = new ArrayList<>();

        for(Object[] result : results){
            Bonus bonus = (Bonus) result[0];
            Payments payments = (Payments) result[1];
            Orders orders = (Orders) result[2];
            Tickets tickets = (Tickets) result[3];
            TicketType ticketType = (TicketType) result[4];
            SeatStatus seatStatus = (SeatStatus) result[5];
            Seat seat = (Seat) result[6];
            Showtimes showtimes = (Showtimes) result[7];
            Movies movies = (Movies) result[8];

            BonusDto bonusDto = convertToBonusDto(bonus, payments, orders, tickets, ticketType, seatStatus, seat, showtimes, movies);
            bonusDtos.add(bonusDto);

            System.out.println("Bonus: " + result);
        }
        return bonusDtos;
    }

    private BonusDto convertToBonusDto(Bonus bonus, Payments payments,
                                       Orders orders, Tickets tickets,
                                       TicketType ticketType, SeatStatus seatStatus,
                                       Seat seat, Showtimes showtimes ,Movies movies){
        BonusDto dto = new BonusDto();
        dto.setBonusId(bonus.getId());
        dto.setPaymentId(payments.getId());
        dto.setOrderId(orders.getId());
        dto.setTicketId(tickets.getId());
        dto.setTicketTypeId(ticketType.getId());
        dto.setSeatStatusId(seatStatus.getId());
        dto.setSeatId(seat.getId());
        dto.setShowtimeId(showtimes.getId());
        dto.setMovieId(movies.getId());

        return dto;
    }

    public Result createBonus(Bonus bonus){
        bonusDao.save(bonus);
        return new Result(200, "success");
    }

    public Result updateBonus(Bonus bonus){
        bonusDao.save(bonus);
        return new Result(200, "success");
    }

    public Result getAll(){
        List<Bonus> list = bonusDao.findAll();
        return new Result(200, list);
    }

//    public Result getBonusByPhone(String phone){
//        List<Bonus> list = bonusDao.findByPhone(phone);
//        System.out.println(list.toString());
//        return new Result(200, list);
//    }
}
