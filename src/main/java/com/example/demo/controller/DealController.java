package com.example.demo.controller;

import com.example.demo.entity.Deal;
import com.example.demo.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Deal", produces = {"application/json;charset=UTF-8"})
public class DealController {
    @Autowired
    DealService dealService;

    @GetMapping("/findByHouseOwner/{houseOwner}")
    List<Deal> findByHouseOwner(@PathVariable("houseOwner") String houseOwner){
        return dealService.findAllByHouseOwner(houseOwner);
    }

    @PostMapping("/saveDeal")
    String saveDeal(@RequestBody Deal deal){
        return dealService.saveOne(deal);
    }

}
