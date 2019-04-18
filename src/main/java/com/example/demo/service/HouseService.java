package com.example.demo.service;

import com.example.demo.entity.House;
import com.example.demo.entity.ResultHouse;

import java.util.List;

public interface HouseService {
    String saveOne(House house);
    String deleteOne(String houseId);
    String updateHouse(House house);
    House findOne(String houseId);
    List<House> findAll();

    List<ResultHouse> findAllHouseInfo();

    List<ResultHouse> findHouseByOwner(String houseOwner);

    String getHouseData();


    String getHouseLayoutData();
}
