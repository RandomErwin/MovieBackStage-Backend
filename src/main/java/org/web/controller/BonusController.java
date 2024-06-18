package org.web.controller;

import org.springframework.web.bind.annotation.*;
import org.web.dto.BonusDto;
import org.web.dto.Result;
import org.web.entity.Bonus;
import org.web.service.BonusService;

import java.util.List;

@RestController
@RequestMapping("/bonus")
public class BonusController {

    private BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @GetMapping("/getBonus/{num}")
    public List<BonusDto>getByOrderNum(@PathVariable String num){
        return bonusService.getByOrderNum(num);
    }

    @PostMapping("/createBonus")
    public Result createBonus(@RequestBody Bonus bonus){
        return bonusService.createBonus(bonus);
    }

    @PutMapping("/updateBonus")
    public Result updateBonus(@RequestBody Bonus bonus){
        return bonusService.updateBonus(bonus);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return bonusService.getAll();
    }

//    // 注意：要加 @PathVariable
//    @GetMapping("/getBonus/{phone}")
//    public Result getBonusByPhone(@PathVariable String phone){
//        return bonusService.getBonusByPhone(phone);
//    }
}
