package org.web.service;

import org.springframework.stereotype.Service;
import org.web.dao.OrderDao;
import org.web.dto.OrderDto;
import org.web.dto.Result;
import org.web.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<OrderDto> getByOrderNum(String num, String method){
        List<Object[]> results = orderDao.findByOrderNumAndMethod(num, method);
        List<OrderDto> orderDtos = new ArrayList<>();

        for(Object[] result : results){
            Orders orderNum = (Orders) result[0];
            Orders totalAmount = (Orders) result[0];
            Orders qrcode = (Orders) result[0];
            Payments payway = (Payments) result[1];
            Payments payStatus = (Payments) result[1];
            Payments modifyTime = (Payments) result[1];
            Payments payTime = (Payments) result[1];
            Bonus bonus = (Bonus) result[2];
            Users userName = (Users) result[3];
            Tickets ticketId = (Tickets) result[4];
            TicketType ticketType = (TicketType) result[5];
            TicketType uniPrice = (TicketType) result[5];
            Seat seatNote = (Seat) result[7];
            Seat rowNumber = (Seat) result[7];
            Seat seatNumber = (Seat) result[7];
            Showtimes showtime = (Showtimes) result[8];
            Movies title = (Movies) result[9];

            OrderDto orderDto = convertToOrderDto(orderNum, totalAmount, qrcode,
                                                    payway, payStatus, modifyTime, payTime,
                                                    bonus, userName, ticketId, ticketType, uniPrice, seatNote,
                                                    rowNumber, seatNumber, showtime, title);
            orderDtos.add(orderDto);
        }

        return orderDtos;
    }

    private OrderDto convertToOrderDto(Orders orderNum, Orders totalAmount, Orders qrcode,
                                       Payments payway, Payments payStatus, Payments modifyTime, Payments payTime,
                                       Bonus bonus, Users userName, Tickets ticketId, TicketType ticketType, TicketType uniPrice,
                                       Seat seatNote, Seat rowNumber, Seat seatNumber, Showtimes showtime, Movies title){
        OrderDto dto = new OrderDto();
        dto.setOrderNum(orderNum.getOrderNum());
        dto.setTotalAmount(totalAmount.getTotalAmount());
        dto.setQrcode(qrcode.getQrcode());
        dto.setPayway(payway.getPayway());
        dto.setPayStatus(payStatus.getPayStatus());
        dto.setModifyTime(modifyTime.getModifyTime());
        dto.setPayTime(payTime.getPayTime());
        dto.setBonus(bonus.getBonus());
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

    public Result createOrder(Orders orders){
        orderDao.save(orders);
        return new Result(200, "success");
    }
    public Result updateOder(Orders orders){
        orderDao.save(orders);
        return new Result(200, "success");
    }
    public Result deleteOrder(Integer id){
        orderDao.deleteById(id);
        return new Result(200, "success");
    }
}
