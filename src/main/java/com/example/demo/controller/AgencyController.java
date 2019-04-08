package com.example.demo.controller;

import com.example.demo.entity.Agency;
import com.example.demo.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Agency", produces = {"application/json;charset=UTF-8"})
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping("/Register")
    public String saveOne(@RequestBody Agency agency) {
        System.out.println(agency.toString());
        return agencyService.saveOne(agency);
    }
    //注册
/*    @GetMapping("/Register")
    public String saveOne(@RequestBody Agency agency) {
        System.out.println(agency.toString());
        return agencyService.saveOne(agency);
    }*/
    //登陆
    @PostMapping("/Login")
    public String AgencyLogin(@RequestBody Agency agency) {
        return agencyService.login(agency);
    }
    //更新信息
    @PostMapping("/Update")
    public String updateAgency(@RequestBody Agency agency){
        return  agencyService.updateAgency(agency);
    }
    //
    @GetMapping("/findAll")
    public List<Agency> findAllAgency(){
        return agencyService.findAll();
    }
    //
    @GetMapping("/findRandomOne")
    public Agency findRandomAgency(){return agencyService.findRandomAgency();}
}
