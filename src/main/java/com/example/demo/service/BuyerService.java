package com.example.demo.service;

import com.example.demo.entity.Buyer;

import java.util.List;

public interface BuyerService {
    String saveOne(Buyer buyer);
    String deleteOne(String buyerId);
    String updateBuyer(Buyer buyer);
    Buyer findOne(String buyerId);
    List<Buyer> findAll();

    String login(Buyer buyer);
}
