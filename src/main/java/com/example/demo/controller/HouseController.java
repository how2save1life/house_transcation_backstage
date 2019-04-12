package com.example.demo.controller;

import com.example.demo.entity.House;
import com.example.demo.entity.ResultHouse;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/House", produces = {"application/json;charset=UTF-8"})
public class HouseController {
    @Autowired
    HouseService houseService;

    @PostMapping("/Save")
    String saveHouse(@RequestBody House house) {
        return houseService.saveOne(house);
    }

    @PostMapping("Update")
    String updateHouse(@RequestBody House house) {
        return houseService.updateHouse(house);
    }
/*    @GetMapping("/findAll")
    List<House> findALLHouse(){
        return  houseService.findAll();
    }*/

    @GetMapping("/findAll")
    List<ResultHouse> findALLHouse() {
        return houseService.findAllHouseInfo();
    }

    @GetMapping("deleteHouse/{houseId}")
    String deleteHouse(@PathVariable(value = "houseId") String houseId) {
        return houseService.deleteOne(houseId);
    }

    @GetMapping("/myHouse/{houseOwner}")
    List<ResultHouse> getMyHouse(@PathVariable(value = "houseOwner")String houseOwner){
        return houseService.findHouseByOwner(houseOwner);
    }

}
