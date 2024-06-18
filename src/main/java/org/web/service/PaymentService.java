package org.web.service;

import org.springframework.stereotype.Service;
import org.web.dao.PaymentsDao;
import org.web.dto.PaymentDto;
import org.web.dto.Result;
import org.web.entity.Bonus;
import org.web.entity.Orders;
import org.web.entity.Payments;
import org.web.entity.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private PaymentsDao paymentsDao;

    public PaymentService(PaymentsDao paymentsDao) {
        this.paymentsDao = paymentsDao;
    }

    public Result createPayment(Payments payments){
        paymentsDao.save(payments);
        return new Result(200, "success");
    }

    public Result updatePayment(Payments payments){
        paymentsDao.save(payments);
        return new Result(200, "success");
    }

    // 注意findAll 需傳回List<> 資料型態
    public Result findAll(){
        List<Payments> payments = paymentsDao.findAll();
        return new Result(200, payments);
    }

    public List<PaymentDto> getByMethod(String method){
        List<Object[]> results = paymentsDao.findByMethod(method);
        List<PaymentDto> paymentDtos = new ArrayList<>();

        for(Object[] result : results){
            Payments payway = (Payments) result[0];
            Payments payStatus = (Payments) result[0];
            Bonus bonus = (Bonus) result[1];
            Orders orderNum = (Orders) result[2];
            Orders totalAmount = (Orders) result[2];
            Users userName = (Users) result[3];

            PaymentDto paymentDto = covertToPaymentDto(payway, payStatus, bonus,
                                                        orderNum, totalAmount, userName);
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }

    // 在Table join後的Entity其屬性可以被取得
    private PaymentDto covertToPaymentDto(Payments payway, Payments payStatus, Bonus bonus,
                                          Orders orderNum, Orders totalAmount, Users userName){
        PaymentDto dto = new PaymentDto();
        dto.setPayway(payway.getPayway());
        dto.setPayStatus(payStatus.getPayStatus());
        dto.setBonus(bonus.getBonus());
        dto.setOrderNum(orderNum.getOrderNum());
        dto.setTotalAmount(totalAmount.getTotalAmount());
        dto.setUserName(userName.getUserName());
        return  dto;
    }

}
