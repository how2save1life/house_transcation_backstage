package com.example.demo.service.impl;

import com.example.demo.entity.House;
import com.example.demo.entity.ResultHouse;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;

    @Override
    public String saveOne(House house) {
        boolean flag = false;
        House isHouse = houseRepository.findOneByHouseNameAndHouseAddrAndHouseOwner(house.getHouseName(), house.getHouseAddr(),house.getHouseOwner());
        if (isHouse == null|| (isHouse != null && !isHouse.getHouseStatus().equals("onsale"))) {
            //该业主在该小区的该房房源未发布过   || 房源曾经发布过 但不是onsale状态            =>保存
            try {
                houseRepository.save(house);
                flag = true;
            } catch (Exception e) {
                System.out.println("save house failed" + e.getMessage());
            }
        } else {
            return "existed";//该房已添加过
        }

        return flag == true ? "success" : "failed";
    }

    @Override
    public String deleteOne(String houseId) {
        boolean flag = false;
        House house = findOne(houseId);
        if (house != null) {//存在
            try {
                houseRepository.delete(house);
                flag = true;
            } catch (Exception e) {
                System.out.println("delete house failed" + e.getMessage());
            }
        } else {
            return "not_existed";
        }

        return flag == true ? "success" : "failed";
    }

    @Override
    public String updateHouse(House house) {
        boolean flag = false;
        String houseId = house.getHouseId();
        String houseAddr = house.getHouseAddr();
        BigDecimal houseArea = house.getHouseArea();
        String houseLayout = house.getHouseLayout();
        String houseName = house.getHouseName();
        BigDecimal housePrice = house.getHousePrice();
        String houseStatus = house.getHouseStatus();
        String houseType = house.getHouseType();
        String houseAgency = house.getHouseAgency();
        if (house.getHouseId() != null) {
            try {
                System.out.println(houseId);
                houseRepository.updateHouse(houseId, houseAddr, houseArea, houseLayout, houseName, housePrice, houseType, houseAgency, houseStatus);
                flag = true;
            } catch (Exception e) {
                System.out.println("update house failed" + e.getMessage());
            }
        } else {
            return "id_required";
        }

        return flag == true ? "success" : "failed";
    }

    @Override
    public House findOne(String houseId) {
        House house = houseRepository.findByHouseId(houseId);
        return house;
    }

    @Override
    public List<House> findAll() {
        List<House> houses = houseRepository.findAll();
        return houses;
    }
    @Override
    public List<ResultHouse> findAllHouseInfo() {
        List<ResultHouse> houses = houseRepository.findAllHouseInfo();
        return houses;
    }
}
