package org.web.service;

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

    public List<BonusDto> getByOrderNum(String num){
        List<Object[]> results = bonusDao.findByOrderNum(num);
        List<BonusDto> bonusDtos = new ArrayList<>();

        for(Object[] result : results){
            Bonus bonus = (Bonus) result[0];
            Payments payway = (Payments) result[1];
            Payments payStatus = (Payments) result[1];
            Payments modifyTime = (Payments) result[1];
            Payments payTime = (Payments) result[1];
            Orders orderNum = (Orders) result[2];
            Orders totalAmount = (Orders) result[2];
            Orders qrcode = (Orders) result[2];
            Users userName = (Users) result[3];
            Tickets ticketId = (Tickets) result[4];
            TicketType ticketType = (TicketType) result[5];
            TicketType uniPrice = (TicketType) result[5];
            Seat seatNote = (Seat) result[7];
            Seat rowNumber = (Seat) result[7];
            Seat seatNumber = (Seat) result[7];
            Showtimes showtime = (Showtimes) result[8];
            Movies title = (Movies) result[9];

            BonusDto bonusDto = convertToBonusDto(bonus, payway, payStatus, modifyTime, payTime,
                                                    orderNum, totalAmount, qrcode, userName,
                                                    ticketId, ticketType, uniPrice, seatNote,
                                                    rowNumber, seatNumber, showtime, title);
            bonusDtos.add(bonusDto);
        }
        return bonusDtos;
    }

    private BonusDto convertToBonusDto(Bonus bonus, Payments payway, Payments payStatus, Payments modifyTime, Payments payTime,
                                       Orders orderNum, Orders totalAmount, Orders qrcode, Users userName,
                                       Tickets ticketId, TicketType ticketType, TicketType uniPrice, Seat seatNote,
                                       Seat rowNumber, Seat seatNumber, Showtimes showtime, Movies title){
        BonusDto dto = new BonusDto();
        dto.setBonus(bonus.getBonus());
        dto.setPayway(payway.getPayway());
        dto.setPayStatus(payStatus.getPayStatus());
        dto.setModifyTime(modifyTime.getModifyTime());
        dto.setPayTime(payTime.getPayTime());
        dto.setOrderNum(orderNum.getOrderNum());
        dto.setTotalAmount(totalAmount.getTotalAmount());
        dto.setQrcode(qrcode.getQrcode());
        dto.setUserName(userName.getUserName());
        dto.setTicketId(ticketId.getId());
        dto.setTicketType(ticketType.getTicketType());
        dto.setUniPrice(uniPrice.getUnitPrice());
        dto.setSeatNote(seatNote.getSeatNote());
        dto.setRowNumber(rowNumber.getRowNumber());
        dto.setSeatNumber(seatNumber.getSeatNumber());
        dto.setShowtime(showtime.getShowTime());
        dto.setTitle(title.getTitle());

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
