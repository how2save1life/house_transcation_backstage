package com.example.demo.controller;

import com.example.demo.entity.Collect;
import com.example.demo.entity.ResultHouse;
import com.example.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Collect" ,produces = {"application/json;charset=UTF-8"})
public class CollectController {
    @Autowired
    CollectService collectService;

    @PostMapping("/Save")
    String saveCollect(@RequestBody Collect collect){
        return collectService.saveOne(collect);
    }

    @PostMapping("/Delete")
    String deleteCollect(@RequestBody Collect collect){
        return collectService.deleteOne(collect);
    }

    @GetMapping("/findCollect/{collectBuyer}")//join
    List<ResultHouse> findCollect(@PathVariable("collectBuyer") String collectBuyer){
        return collectService.findAllByBuyer(collectBuyer);
    }
}
