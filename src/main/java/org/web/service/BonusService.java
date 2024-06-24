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

    public List<BonusDto> getBonus(){
        List<Object[]> results = bonusDao.findBonus();
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

            BonusDto bonusDto = convertToBonusDto(bonus, payway, payStatus, modifyTime, payTime,
                                                    orderNum, totalAmount, qrcode, userName);
            bonusDtos.add(bonusDto);
        }
        return bonusDtos;
    }

    private BonusDto convertToBonusDto(Bonus bonus, Payments payway, Payments payStatus, Payments modifyTime, Payments payTime,
                                       Orders orderNum, Orders totalAmount, Orders qrcode, Users userName){
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

}
