package org.web.service;

import org.springframework.stereotype.Service;
import org.web.dao.BonusDao;
import org.web.dto.Result;
import org.web.entity.Bonus;

import java.util.List;

@Service
public class BonusService {

    private BonusDao bonusDao;

    public BonusService(BonusDao bonusDao) {
        this.bonusDao = bonusDao;
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

    public Result getBonusByPhone(String phone){
        List<Bonus> list = bonusDao.findByPhone(phone);
        System.out.println(list.toString());
        return new Result(200, list);
    }
}
