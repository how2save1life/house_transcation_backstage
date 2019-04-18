package com.example.demo.controller;

import com.example.demo.entity.Deal;
import com.example.demo.entity.ResultAll;
import com.example.demo.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Deal", produces = {"application/json;charset=UTF-8"})
public class DealController {
    @Autowired
    DealService dealService;

    @GetMapping("/findByUser")
    List<ResultAll> findByUser(@RequestParam("User") String User,@RequestParam("userId") String userId){
        return dealService.findAllByUser(User,userId);
    }

    @PostMapping("/saveDeal")
    String saveDeal(@RequestBody Deal deal){
        return dealService.saveOne(deal);
    }

    @PostMapping("Update")
    String updateDeal(@RequestBody Deal deal){return dealService.updateOne(deal);}

    @GetMapping("/dealData")
    String getDealData(){return dealService.getDealData();}

}
