package com.example.demo.service;

import com.example.demo.entity.Deal;
import com.example.demo.entity.ResultAll;

import java.util.List;

public interface DealService {
    String saveOne(Deal deal);
    String updateOne(Deal deal);
    List<Deal> findAll();

    List<Deal> findAllByDealAgency(String dealAgency);

    List<Deal> findAllByDealBuyer(String dealBuyer);

    List<Deal> findAllByDealHouse(String dealHouse);

    List<Deal> findAllByHouseOwner(String houseOwner);

    List<ResultAll> findAllByUser(String User, String userId);

    String getDealData();
}
