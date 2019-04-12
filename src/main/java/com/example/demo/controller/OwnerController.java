package com.example.demo.controller;

import com.example.demo.entity.Agency;
import com.example.demo.entity.Owner;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

@RestController
@RequestMapping(value = "/Owner", produces = {"application/json;charset=UTF-8"})
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/Register")
    public String saveOne(@RequestBody Owner owner) {
        return ownerService.saveOne(owner);
    }

    @PostMapping("/Login")
    public String OwnerLogin(@RequestBody Owner owner) {
        return ownerService.login(owner);
    }

    //更新信息
    @PostMapping("/Update")
    public String updateOwner(@RequestBody Owner owner) {
        return ownerService.updateOwner(owner);
    }

    //
    @GetMapping("/findAll")
    public List<Owner> FindAllOwner() {
        return ownerService.findAll();
    }

    //
    @GetMapping("/findMe/{OwnerId}")
    public Owner findOne(@PathVariable("OwnerId") String OwnerId) {
        return ownerService.findOne(OwnerId);
    }


}
