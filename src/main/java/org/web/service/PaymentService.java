package org.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.dao.BonusDao;
import org.web.dao.PaymentsDao;
import org.web.dto.PaymentDto;
import org.web.dto.Result;
import org.web.entity.Bonus;
import org.web.entity.Orders;
import org.web.entity.Payments;
import org.web.entity.Users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private PaymentsDao paymentsDao;
    private BonusDao bonusDao;

    public PaymentService(PaymentsDao paymentsDao, BonusDao bonusDao) {
        this.paymentsDao = paymentsDao;
        this.bonusDao = bonusDao;
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
        // JPA操作資料庫，取得join後的所有的資料放入List<Object[]> results =>  篩選出需要的欄位(屬性)逐筆放入(映射)DTO容器裡面
        // Object[] => 容納結合多張表，具有多樣物件(含型別、屬性)
        // PaymentDto => 作為資料傳遞的乾淨容器
        List<Object[]> results = paymentsDao.findByMethod(method);
        List<PaymentDto> paymentDtos = new ArrayList<>();

        // 將逐筆 result[index] 分別放入 DTO 承接的屬性裡
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

    @Transactional
    public Result createRefundPaymentByOrderNum(String orderNum){
        LocalDateTime modifyTime = LocalDateTime.now();
        paymentsDao.insertRefundPaymentByOrderNum(orderNum, modifyTime);

        Integer totalAmount = paymentsDao.findTotalAmountByOrderNum(orderNum);
        Integer paymentId = paymentsDao.getLastInsertedId();
        Integer currentBonus = bonusDao.findBonusByPaymentId(paymentId);
        Integer deduction = totalAmount/100;
        Integer newBonus = currentBonus - deduction;
        bonusDao.insertBonusByPaymentId(newBonus, modifyTime, paymentId);

        return new Result(200, "success");
    }

}
