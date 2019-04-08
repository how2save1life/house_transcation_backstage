package com.example.demo.controller;

import com.example.demo.entity.Buyer;
import com.example.demo.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Buyer",produces ={"application/json;charset=UTF-8"})
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @PostMapping("/Register")
    String saveOne(@RequestBody Buyer buyer){
        return buyerService.saveOne(buyer);
    }

    @PostMapping("/Login")
    String buyerLogin(@RequestBody Buyer buyer){
        return buyerService.login(buyer);
    }

    @PostMapping("/Update")
    String buyerUpdate(@RequestBody Buyer buyer){
        return buyerService.updateBuyer(buyer);
    }

    @GetMapping("findAll")
    List<Buyer> findAll(){
        return buyerService.findAll();
    }
}
